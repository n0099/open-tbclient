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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private static void ol(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> fv = ay.fv(str);
        if (fv != null) {
            am amVar = new am("c10320");
            amVar.ax("obj_locate", fv.get("obj_locate"));
            amVar.x("obj_type", 1);
            amVar.ax(ImageViewerConfig.FORUM_NAME, fv.get("kw"));
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, fv.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            amVar.ax("obj_param2", fv.get("obj_param2"));
            amVar.x("obj_to", 2);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, fv.get("bdid"));
            if (!ao.isEmpty(fv.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(fv.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        amVar.ax(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    public static d O(Intent intent) {
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
                    ol(decode);
                }
                dVar.forumName = matcher.group(2);
            } else {
                ol(decode);
                int indexOf = decode.indexOf("kw=");
                if (indexOf < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
                    return null;
                }
                dVar.forumName = decode.substring(length);
                try {
                    dVar.dUG = data.getQueryParameter("from");
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

    public static Intent av(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean aw(Context context, String str) {
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
                if (ab.aX(TbadkCoreApplication.getInst().getApplicationContext())) {
                    ak.b(frsFragment.getPageContext());
                } else {
                    frsFragment.showToast(e.j.system_permission_prompt_camera);
                }
                ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
                if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    frsFragment.showToast(e.j.sdcard_permission_denied_advert_for_camera);
                }
            } else if (i == 25040) {
                com.baidu.tieba.frs.entelechy.c aCj = frsFragment.azX().aCj();
                String wY = aCj.wY();
                String aCA = aCj.aCA();
                if (iArr[0] == 0 && strArr[0].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, wY));
                } else {
                    ay.CU().c(frsFragment.getPageContext(), new String[]{aCA});
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, l lVar) {
        if (tbPageContext != null && lVar != null) {
            com.baidu.tbadk.browser.a.a(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + lVar.beT().getId(), true, true, true);
        }
    }

    public static void a(FrsFragment frsFragment, String str, bb bbVar, boolean z) {
        if (frsFragment != null && bbVar != null && str != null) {
            if (!(bbVar == null || bbVar.zk())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, frsFragment.getForumName(), "frs_page", 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setStartFrom(3);
                frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, frsFragment.getForumName(), "frs_page", 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg2));
        }
    }

    public static void b(FrsFragment frsFragment, String str, bb bbVar, boolean z) {
        if (frsFragment != null && bbVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, frsFragment.getForumName(), "frs_page", 18003, false, false, z);
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
                    com.baidu.tbadk.core.e.b.k(tbPageContext.getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.e.b.k(tbPageContext.getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public static void a(FrsFragment frsFragment, bb bbVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (frsFragment != null && bbVar != null) {
            String valueOf = String.valueOf(bbVar.getFid());
            if (bbVar.arp == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bbVar.arp.id;
                str2 = valueOf;
            }
            if (bbVar.yS() > 0 && com.baidu.tieba.tbadkCore.util.e.bDb()) {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(bbVar.getTid(), String.valueOf(bbVar.yS()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, frsFragment.getForumName(), "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bbVar.zx());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bbVar.zm() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
