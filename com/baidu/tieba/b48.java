package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.ResourceConstants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext tbPageContext, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65536, null, tbPageContext, intent, str) != null) || tbPageContext == null) {
            return;
        }
        if (intent != null && !intent.getBooleanExtra("back_special", false)) {
            tbPageContext.getPageActivity().finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1)));
            } else {
                MainEntrance.goToMainTab(tbPageContext.getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
        } else {
            MainEntrance.goToMainTab(tbPageContext.getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.getPageActivity().finish();
        }
    }

    public static r38 b(Intent intent) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (intent == null || intent.getParcelableExtra(IntentConfig.KEY_URI) == null) {
                return null;
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            r38 r38Var = new r38();
            if (!StringUtils.isNull(uri2) && uri2.startsWith("tbfrs://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    return null;
                }
                Matcher matcher = Pattern.compile(".*fr=(.*)&kw=(.*)").matcher(decode);
                if (matcher.find()) {
                    if ("bpush".equals(matcher.group(1))) {
                        o(decode);
                    }
                    r38Var.a = matcher.group(2);
                } else {
                    o(decode);
                    int indexOf = decode.indexOf("kw=");
                    if (indexOf < 0 || (i = indexOf + 3) > decode.length()) {
                        return null;
                    }
                    r38Var.a = decode.substring(i);
                    try {
                        uri.getQueryParameter("from");
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", uri2);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            return r38Var;
        }
        return (r38) invokeL.objValue;
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            if (str.startsWith(ResourceConstants.CMT)) {
                str = str.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(str);
            if (paramPair != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                bp4.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("fname", paramPair.get(TiebaStatic.Params.H5_FORUM_NAME));
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 2);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!qd.isEmpty(paramPair.get(BasicVideoParserKt.EXT_LOG))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get(BasicVideoParserKt.EXT_LOG));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static int c(FrsViewData frsViewData, vp7 vp7Var) {
        InterceptResult invokeLL;
        fx4 fx4Var;
        int dimens;
        int dimens2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, frsViewData, vp7Var)) == null) {
            if (frsViewData != null && frsViewData.getActivityHeadData() != null && !ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) {
                fx4Var = frsViewData.getActivityHeadData().b().get(0);
            } else {
                fx4Var = null;
            }
            if (fx4Var == null) {
                return 0;
            }
            if (m(frsViewData)) {
                dimens = ((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) * 9) / 16) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds96);
                if (l(frsViewData)) {
                    dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                    dimens += dimens2;
                }
                if (frsViewData.frsGameRankInfoData == null || frsViewData.frsBannerHeaderData != null) {
                    return dimens + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds125);
                }
                return dimens;
            }
            dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds782);
            if (l(frsViewData)) {
                dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                dimens += dimens2;
            }
            if (frsViewData.frsGameRankInfoData == null) {
            }
            return dimens + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds125);
        }
        return invokeLL.intValue;
    }

    public static Intent d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent(context, DealIntentService.class);
                intent.putExtra("class", 2);
                intent.putExtra("fname", str);
                intent.putExtra("from", "nas");
                return intent;
            }
            return null;
        }
        return (Intent) invokeLL.objValue;
    }

    public static void e(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, frsViewData) == null) && tbPageContext != null && frsViewData != null) {
            BrowserHelper.startWebActivity(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + frsViewData.getForum().getId(), true, true, true);
        }
    }

    public static boolean j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.topActivity.getClassName().equals(str)) {
                    if (next.numActivities <= 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void f(FrsFragment frsFragment, ThreadData threadData, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{frsFragment, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && frsFragment != null && threadData != null) {
            String str = null;
            String valueOf = String.valueOf(threadData.getFid());
            OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                str = valueOf;
            }
            if (threadData.getLastReadPid() > 0 && zsa.c()) {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(threadData.getTid(), String.valueOf(threadData.getLastReadPid()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.v(), "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(threadData.isSmartFrsThread());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(valueOf);
            createFromThreadCfg.setFromForumId(str);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (threadData.isInterviewLiveStyle() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && n(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                qp7.e(threadData);
            }
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void g(FrsFragment frsFragment, String str, ThreadData threadData, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{frsFragment, str, threadData, Boolean.valueOf(z)}) == null) && frsFragment != null && threadData != null && str != null) {
            if (threadData != null && !threadData.isAnonymityUser()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.v(), "frs_page", 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setStartFrom(3);
                frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.v(), "frs_page", 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg2));
        }
    }

    public static void h(FrsFragment frsFragment, String str, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{frsFragment, str, threadData, Boolean.valueOf(z)}) == null) && frsFragment != null && threadData != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.v(), "frs_page", 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void i(FrsFragment frsFragment, int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65544, null, frsFragment, i, strArr, iArr) == null) && frsFragment != null && strArr != null && iArr != null && i == 1) {
            if (PermissionUtil.checkCamera(TbadkCoreApplication.getInst().getApplicationContext())) {
                SelectImageHelper.takePhoto(frsFragment.getPageContext());
            } else {
                frsFragment.showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                frsFragment.showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, frsViewData)) == null) {
            if (frsViewData != null && frsViewData.getHotUserRankData() != null && frsViewData.getHotUserRankData().hot_user != null && frsViewData.getHotUserRankData().hot_user.size() >= 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            if (i != 0 && i != 11 && i != 40 && !threadData.isUgcThreadType()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean l(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, frsViewData)) == null) {
            if ((frsViewData != null && frsViewData.serviceAreaData != null) || k(frsViewData)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean m(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getActivityHeadData() == null) {
                return false;
            }
            ArrayList<fx4> b = frsViewData.getActivityHeadData().b();
            fx4 fx4Var = null;
            if (!ListUtils.isEmpty(b)) {
                fx4Var = b.get(0);
            }
            if (fx4Var == null || StringUtils.isNull(fx4Var.c()) || StringUtils.isNull(fx4Var.h())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
