package com.baidu.tieba.frs.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveHeadlineActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveListActivityConfig;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private static void me(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> el = av.el(str);
        if (el != null) {
            ak akVar = new ak("c10320");
            akVar.aa("obj_locate", el.get("obj_locate"));
            akVar.s("obj_type", 1);
            akVar.aa(ImageViewerConfig.FORUM_NAME, el.get("kw"));
            akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, el.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            akVar.aa("obj_param2", el.get("obj_param2"));
            akVar.s("obj_to", 2);
            akVar.aa("obj_id", el.get("bdid"));
            if (!am.isEmpty(el.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(el.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        akVar.aa(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(akVar);
        }
    }

    public static String N(Intent intent) {
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (StringUtils.isNull(dataString) || !dataString.startsWith("tbfrs://")) {
            return null;
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode)) {
            return null;
        }
        Matcher matcher = Pattern.compile(".*fr=(.*)&kw=(.*)").matcher(decode);
        if (matcher.find()) {
            if (!"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                me(decode);
            }
            return matcher.group(2);
        }
        me(decode);
        int indexOf = decode.indexOf("kw=");
        if (indexOf < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public static Intent ad(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean ae(Context context, String str) {
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

    public static void a(com.baidu.tieba.frs.i iVar, int i, String[] strArr, int[] iArr) {
        if (iVar != null && strArr != null && iArr != null && i == 1) {
            if (ab.aU(TbadkCoreApplication.getInst().getApplicationContext())) {
                ai.c(iVar.getPageContext());
            } else {
                iVar.showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                iVar.showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static void z(com.baidu.tieba.frs.i iVar) {
        if (iVar != null && ax.bb(iVar.getActivity())) {
            TiebaStatic.log(new ak("c10177").aa(ImageViewerConfig.FORUM_ID, iVar.getForumId()));
            iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(iVar.getPageContext().getPageActivity(), String.valueOf(iVar.getForumId()), false, 0)));
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, bd bdVar) {
        if (iVar != null && bdVar != null && ax.bb(iVar.getActivity())) {
            iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(iVar.getPageContext().getPageActivity()).createConfig(String.valueOf(iVar.getForumId()), bdVar.getTid(), 1)));
        }
    }

    public static void a(TbPageContext tbPageContext, l lVar) {
        if (tbPageContext != null && lVar != null) {
            com.baidu.tbadk.browser.a.a(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + lVar.aYJ().getId(), true, true, true);
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, String str, bd bdVar, boolean z) {
        if (iVar != null && bdVar != null && str != null) {
            if (!(bdVar == null || bdVar.zH())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(iVar.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, iVar.getForumName(), "frs_page", 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
                createFromThreadCfg.setStartFrom(3);
                iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(iVar.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, iVar.getForumName(), "frs_page", 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg2.setStartFrom(3);
            iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(com.baidu.tieba.frs.i iVar, String str, bd bdVar, boolean z) {
        if (iVar != null && bdVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(iVar.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, iVar.getForumName(), "frs_page", 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setStartFrom(3);
            iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
                    com.baidu.tbadk.core.e.b.u(tbPageContext.getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.e.b.u(tbPageContext.getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public static void b(com.baidu.tieba.frs.i iVar, bd bdVar) {
        PhotoLiveActivityConfig wQ;
        if (iVar != null && bdVar != null) {
            if (bdVar.getThreadType() == 33 || (bdVar instanceof as)) {
                if (bdVar.zq() > 0 && com.baidu.tieba.tbadkCore.util.f.bwK()) {
                    wQ = new PhotoLiveActivityConfig.a(iVar.getPageContext().getPageActivity(), bdVar.getTid()).cG("from_frs").eC(18003).cE(String.valueOf(bdVar.zq())).wQ();
                } else {
                    wQ = new PhotoLiveActivityConfig.a(iVar.getPageContext().getPageActivity(), bdVar.getTid()).cG("from_frs").eC(18003).wQ();
                }
                iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, wQ));
            }
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, bd bdVar, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (iVar != null && bdVar != null) {
            if (bdVar.zq() > 0 && com.baidu.tieba.tbadkCore.util.f.bwK()) {
                createFromThreadCfg = new PbActivityConfig(iVar.getPageContext().getPageActivity()).createHistoryCfg(bdVar.getTid(), String.valueOf(bdVar.zq()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(iVar.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, iVar.getForumName(), "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bdVar.zU());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setStartFrom(3);
            if (bdVar.zI() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
