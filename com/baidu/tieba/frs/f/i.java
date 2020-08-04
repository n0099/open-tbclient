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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
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
/* loaded from: classes16.dex */
public class i {
    private static void Gv(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = bd.getParamPair(str);
        if (paramPair != null) {
            ap apVar = new ap("c10320");
            apVar.dn("obj_locate", paramPair.get("obj_locate"));
            apVar.ah("obj_type", 1);
            apVar.dn("fname", paramPair.get("kw"));
            apVar.dn("obj_source", paramPair.get("obj_source"));
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            apVar.ah(TiebaInitialize.Params.OBJ_TO, 2);
            apVar.dn("obj_id", paramPair.get("bdid"));
            if (!as.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        apVar.dn(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(apVar);
        }
    }

    public static d V(Intent intent) {
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
                    Gv(decode);
                }
                dVar.forumName = matcher.group(2);
            } else {
                Gv(decode);
                int indexOf = decode.indexOf("kw=");
                if (indexOf >= 0 && (length = indexOf + "kw=".length()) <= decode.length()) {
                    dVar.forumName = decode.substring(length);
                    try {
                        dVar.ieJ = uri.getQueryParameter("from");
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

    public static Intent aB(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 2);
        intent.putExtra("fname", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean aC(Context context, String str) {
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
            if (ad.checkCamera(TbadkCoreApplication.getInst().getApplicationContext())) {
                an.g(frsFragment.getPageContext());
            } else {
                frsFragment.showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
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

    public static void a(FrsFragment frsFragment, String str, bv bvVar, boolean z) {
        if (frsFragment != null && bvVar != null && str != null) {
            if (!(bvVar == null || bvVar.aXp())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bvVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setStartFrom(3);
                frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bvVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(FrsFragment frsFragment, String str, bv bvVar, boolean z) {
        if (frsFragment != null && bvVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bvVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, false, false, z);
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

    public static void a(FrsFragment frsFragment, bv bvVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (frsFragment != null && bvVar != null) {
            String valueOf = String.valueOf(bvVar.getFid());
            if (bvVar.dUt == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bvVar.dUt.id;
                str2 = valueOf;
            }
            if (bvVar.aWI() > 0 && com.baidu.tieba.tbadkCore.util.e.dmq()) {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(bvVar.getTid(), String.valueOf(bvVar.aWI()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bvVar, frsFragment.getForumName(), "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bvVar.aXA());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bvVar.aXs() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(bvVar)) {
                createFromThreadCfg.setNeedPreLoad(true);
                k.ak(bvVar);
            }
            frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean v(bv bvVar) {
        if (bvVar == null || bvVar.isShareThread) {
            return false;
        }
        int i = bvVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bvVar.aUV();
    }
}
