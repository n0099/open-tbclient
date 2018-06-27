package com.baidu.tieba.frs.f;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    private static void nc(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> eR = az.eR(str);
        if (eR != null) {
            an anVar = new an("c10320");
            anVar.ah("obj_locate", eR.get("obj_locate"));
            anVar.r("obj_type", 1);
            anVar.ah(ImageViewerConfig.FORUM_NAME, eR.get("kw"));
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eR.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            anVar.ah("obj_param2", eR.get("obj_param2"));
            anVar.r("obj_to", 2);
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, eR.get("bdid"));
            if (!ap.isEmpty(eR.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(eR.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.ah(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    public static d K(Intent intent) {
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        Uri data = intent.getData();
        String uri = data.toString();
        d dVar = new d();
        if (!StringUtils.isNull(uri) && uri.startsWith("tbfrs://")) {
            String decode = Uri.decode(data.getEncodedPath());
            if (StringUtils.isNull(decode)) {
                return null;
            }
            Matcher matcher = Pattern.compile(".*fr=(.*)&kw=(.*)").matcher(decode);
            if (matcher.find()) {
                if (!"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                    nc(decode);
                }
                dVar.forumName = matcher.group(2);
            } else {
                nc(decode);
                int indexOf = decode.indexOf("kw=");
                if (indexOf < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
                    return null;
                }
                dVar.forumName = decode.substring(length);
                try {
                    dVar.dCW = data.getQueryParameter("from");
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
            httpMessage.addParam("call_url", uri);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        return dVar;
    }

    public static Intent ac(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean ad(Context context, String str) {
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
        if (frsFragment != null && strArr != null && iArr != null) {
            if (i == 1) {
                if (ac.aN(TbadkCoreApplication.getInst().getApplicationContext())) {
                    al.b(frsFragment.getPageContext());
                } else {
                    frsFragment.showToast(d.k.system_permission_prompt_camera);
                }
                ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
                if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    frsFragment.showToast(d.k.sdcard_permission_denied_advert_for_camera);
                }
            } else if (i == 25040) {
                com.baidu.tieba.frs.entelechy.c avY = frsFragment.auf().avY();
                String ub = avY.ub();
                String awp = avY.awp();
                if (iArr[0] == 0 && strArr[0].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, ub));
                } else {
                    az.zV().c(frsFragment.getPageContext(), new String[]{awp});
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, l lVar) {
        if (tbPageContext != null && lVar != null) {
            com.baidu.tbadk.browser.a.a(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + lVar.baT().getId(), true, true, true);
        }
    }

    public static void a(FrsFragment frsFragment, String str, bc bcVar, boolean z) {
        if (frsFragment != null && bcVar != null && str != null) {
            if (!(bcVar == null || bcVar.wi())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bcVar, frsFragment.getForumName(), "frs_page", 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setStartFrom(3);
                frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bcVar, frsFragment.getForumName(), "frs_page", 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg2));
        }
    }

    public static void b(FrsFragment frsFragment, String str, bc bcVar, boolean z) {
        if (frsFragment != null && bcVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bcVar, frsFragment.getForumName(), "frs_page", 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
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
                    tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1)));
                } else {
                    com.baidu.tbadk.core.e.b.g(tbPageContext.getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.e.b.g(tbPageContext.getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public static void a(FrsFragment frsFragment, bc bcVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (frsFragment != null && bcVar != null) {
            String valueOf = String.valueOf(bcVar.getFid());
            if (bcVar.akt == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bcVar.akt.id;
                str2 = valueOf;
            }
            if (bcVar.vR() > 0 && com.baidu.tieba.tbadkCore.util.e.byE()) {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(bcVar.getTid(), String.valueOf(bcVar.vR()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bcVar, frsFragment.getForumName(), "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bcVar.wv());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bcVar.wk() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
