package com.baidu.tieba.frs.f;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    private static void FJ(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = bc.getParamPair(str);
        if (paramPair != null) {
            ao aoVar = new ao("c10320");
            aoVar.dk("obj_locate", paramPair.get("obj_locate"));
            aoVar.ag("obj_type", 1);
            aoVar.dk("fname", paramPair.get("kw"));
            aoVar.dk("obj_source", paramPair.get("obj_source"));
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            aoVar.ag(TiebaInitialize.Params.OBJ_TO, 2);
            aoVar.dk("obj_id", paramPair.get("bdid"));
            if (!ar.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        aoVar.dk(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(aoVar);
        }
    }

    public static d U(Intent intent) {
        int length;
        if (intent == null || intent.getParcelableExtra(IntentConfig.KEY_URI) == null) {
            return null;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        String uri2 = uri.toString();
        d dVar = new d();
        if (!StringUtils.isNull(uri2) && uri2.startsWith("tbfrs://")) {
            String decode = Uri.decode(uri.getEncodedPath());
            if (StringUtils.isNull(decode)) {
                return null;
            }
            Matcher matcher = Pattern.compile(".*fr=(.*)&kw=(.*)").matcher(decode);
            if (matcher.find()) {
                if (!"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                    FJ(decode);
                }
                dVar.forumName = matcher.group(2);
            } else {
                FJ(decode);
                int indexOf = decode.indexOf("kw=");
                if (indexOf >= 0 && (length = indexOf + "kw=".length()) <= decode.length()) {
                    dVar.forumName = decode.substring(length);
                    try {
                        dVar.hYF = uri.getQueryParameter("from");
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            HttpMessage httpMessage = new HttpMessage(1003393);
            httpMessage.addParam("call_url", uri2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        return dVar;
    }

    public static Intent aC(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 2);
        intent.putExtra("fname", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean aD(Context context, String str) {
        Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(10).iterator();
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

    public static void a(FrsFragment frsFragment, int i, String[] strArr, int[] iArr) {
        if (frsFragment != null && strArr != null && iArr != null && i == 1) {
            if (ac.checkCamera(TbadkCoreApplication.getInst().getApplicationContext())) {
                am.g(frsFragment.getPageContext());
            } else {
                frsFragment.showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ac.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                frsFragment.showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static void c(TbPageContext tbPageContext, FrsViewData frsViewData) {
        if (tbPageContext != null && frsViewData != null) {
            com.baidu.tbadk.browser.a.startWebActivity(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + frsViewData.getForum().getId(), true, true, true);
        }
    }

    public static void a(FrsFragment frsFragment, String str, bu buVar, boolean z) {
        if (frsFragment != null && buVar != null && str != null) {
            if (!(buVar == null || buVar.aTt())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(buVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setStartFrom(3);
                frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(buVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(FrsFragment frsFragment, String str, bu buVar, boolean z) {
        if (frsFragment != null && buVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(buVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(TbPageContext tbPageContext, Intent intent, String str) {
        if (tbPageContext != null) {
            if (intent != null && !intent.getBooleanExtra("back_special", false)) {
                tbPageContext.getPageActivity().finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1)));
                } else {
                    com.baidu.tbadk.core.e.b.q(tbPageContext.getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.e.b.q(tbPageContext.getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public static void a(FrsFragment frsFragment, bu buVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (frsFragment != null && buVar != null) {
            String valueOf = String.valueOf(buVar.getFid());
            if (buVar.dOi == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = buVar.dOi.id;
                str2 = valueOf;
            }
            if (buVar.aSM() > 0 && com.baidu.tieba.tbadkCore.util.e.djg()) {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(buVar.getTid(), String.valueOf(buVar.aSM()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(buVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(buVar.aTE());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (buVar.aTw() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && u(buVar)) {
                createFromThreadCfg.setNeedPreLoad(true);
                k.an(buVar);
            }
            frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean u(bu buVar) {
        if (buVar == null || buVar.isShareThread) {
            return false;
        }
        int i = buVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return buVar.aQZ();
    }
}
