package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public final class eu7 implements k75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eu7() {
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
            sg.h().m(resultBgUrl, 59, null, null);
        }
    }

    public final void c(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeColorInfo) != null) || themeColorInfo == null) {
            return;
        }
        final String g = qla.g(themeColorInfo);
        if (!StringUtils.isNotNull(g)) {
            dh.c(new Runnable() { // from class: com.baidu.tieba.lt7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        eu7.d(g);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k75
    public Map<String, Object> a(DialogStrategiesData dialogData, Map<String, Object> strategyData, Map<String, Object> extraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogData, strategyData, extraData)) == null) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            Intrinsics.checkNotNullParameter(strategyData, "strategyData");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            HashMap hashMap = new HashMap(strategyData);
            hashMap.put("dialogName", "frsNewUserGuide");
            hashMap.putAll(strategyData);
            hashMap.putAll(extraData);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.k75
    public boolean b(Map<String, Object> map) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        FrsViewData c1;
        FrsSpriteNewUserGuide frsSpriteNewUserGuide;
        long j;
        FrsViewData c12;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!(currentActivity instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "新用户弹窗策略校验失败：当前Activity非FrsActivity");
                return false;
            }
            ThemeColorInfo themeColorInfo = null;
            if (!mo5.g(false, 1, null)) {
                YunDialogLog.getInstance().b("YunDialogManager", "新用户弹窗策略校验失败：动画资源未就绪");
                return false;
            } else if (!sp5.a.a().b()) {
                YunDialogLog.getInstance().b("YunDialogManager", "新用户弹窗策略校验失败：非新用户");
                return false;
            } else {
                FrsActivity frsActivity = (FrsActivity) currentActivity;
                jp7 x1 = frsActivity.x1();
                if (x1 != null && x1.p0()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    YunDialogLog.getInstance().b("YunDialogManager", "新用户弹窗策略校验失败：用户已关注本吧");
                    return false;
                }
                jp7 x12 = frsActivity.x1();
                if (x12 != null && x12.V()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    YunDialogLog.getInstance().b("YunDialogManager", "新用户弹窗策略校验失败：底部直播动画弹窗存在互斥");
                    return false;
                }
                FrsFragment v1 = frsActivity.v1();
                if (v1 == null || (c1 = v1.c1()) == null || (frsSpriteNewUserGuide = c1.frsSpriteNewUserGuide) == null) {
                    return false;
                }
                if (!frsSpriteNewUserGuide.isValid()) {
                    YunDialogLog.getInstance().b("YunDialogManager", "新用户弹窗策略校验失败：该吧未下发新用户引导配置");
                    return false;
                }
                FrsFragment v12 = frsActivity.v1();
                if (v12 != null && (c12 = v12.c1()) != null && (forum = c12.getForum()) != null) {
                    forum.getId();
                }
                long millis = TimeUnit.SECONDS.toMillis(frsSpriteNewUserGuide.bubblePeriod);
                FrsFragment v13 = frsActivity.v1();
                if (v13 != null) {
                    j = v13.O3();
                } else {
                    j = -1;
                }
                if (j > 0 && System.currentTimeMillis() - j < millis) {
                    return false;
                }
                FrsSpriteNewUserGuide.BubbleText bubbleText = frsSpriteNewUserGuide.bubbleText;
                if (bubbleText != null) {
                    themeColorInfo = bubbleText.bgUrlTheme;
                }
                c(themeColorInfo);
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
