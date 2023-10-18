package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
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
public final class dp7 implements e15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dp7() {
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
        final String g = boa.g(themeColorInfo);
        if (!StringUtils.isNotNull(g)) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.jo7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        dp7.d(g);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.e15
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

    @Override // com.baidu.tieba.e15
    public boolean b(Map<String, Object> map) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        FrsViewData s1;
        FrsSpriteNewUserGuide frsSpriteNewUserGuide;
        long j;
        FrsViewData s12;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!(currentActivity instanceof FrsActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：当前Activity非FrsActivity");
                return false;
            }
            ThemeColorInfo themeColorInfo = null;
            if (!mi5.g(false, 1, null)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：动画资源未就绪");
                return false;
            } else if (!pj5.a.a().b()) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：非新用户");
                return false;
            } else {
                FrsActivity frsActivity = (FrsActivity) currentActivity;
                pk7 w1 = frsActivity.w1();
                if (w1 != null && w1.p0()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：用户已关注本吧");
                    return false;
                }
                pk7 w12 = frsActivity.w1();
                if (w12 != null && w12.U()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：底部直播动画弹窗存在互斥");
                    return false;
                }
                FrsFragment r1 = frsActivity.r1();
                if (r1 == null || (s1 = r1.s1()) == null || (frsSpriteNewUserGuide = s1.frsSpriteNewUserGuide) == null) {
                    return false;
                }
                if (!frsSpriteNewUserGuide.isValid()) {
                    YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：该吧未下发新用户引导配置");
                    return false;
                }
                FrsFragment r12 = frsActivity.r1();
                if (r12 != null && (s12 = r12.s1()) != null && (forum = s12.getForum()) != null) {
                    forum.getId();
                }
                long millis = TimeUnit.SECONDS.toMillis(frsSpriteNewUserGuide.bubblePeriod);
                FrsFragment r13 = frsActivity.r1();
                if (r13 != null) {
                    j = r13.j4();
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
