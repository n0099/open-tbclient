package com.baidu.tieba.frs.g;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveHeadlineActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveListActivityConfig;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private static void kV(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> dT = av.dT(str);
        if (dT != null) {
            ak akVar = new ak("c10320");
            akVar.ad("obj_locate", dT.get("obj_locate"));
            akVar.r("obj_type", 1);
            akVar.ad(ImageViewerConfig.FORUM_NAME, dT.get("kw"));
            akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dT.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            akVar.ad("obj_param2", dT.get("obj_param2"));
            akVar.r("obj_to", 2);
            akVar.ad("obj_id", dT.get("bdid"));
            if (!am.isEmpty(dT.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(dT.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        akVar.ad(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(akVar);
        }
    }

    public static String M(Intent intent) {
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
                kV(decode);
            }
            return matcher.group(2);
        }
        kV(decode);
        int indexOf = decode.indexOf("kw=");
        if (indexOf < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public static Intent ah(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static void a(ListView listView) {
        Object d;
        if (listView != null && (d = com.baidu.adp.lib.OrmObject.a.a.d(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.OrmObject.a.a.a("clear", d, d.getClass());
        }
    }

    public static Intent ai(Context context, String str) {
        Class<?> intentClass;
        if (str == null || str.length() <= 0 || (intentClass = TbadkCoreApplication.getInst().getIntentClass(LogoActivityConfig.class)) == null) {
            return null;
        }
        Intent intent = new Intent(context, intentClass);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(603979776);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
        intent.putExtra("back_special", true);
        intent.putExtra("from", "short_cut");
        return intent;
    }

    public static boolean aj(Context context, String str) {
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

    public static boolean ak(Context context, String str) {
        String str2;
        String str3 = Build.MODEL;
        if (!TextUtils.isEmpty(str3) && str3.startsWith("MI")) {
            str2 = "content://com.miui.home.launcher.settings/favorites?notify=true";
        } else if (!TextUtils.isEmpty(str3) && str3.equals("MT788")) {
            str2 = "content://com.motorola.mmsp.motohomex.settings/favorites?notify=true";
        } else if (Build.VERSION.SDK_INT < 8) {
            str2 = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            str2 = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        Cursor query = context.getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{str + context.getString(d.l.forum)}, null);
        boolean z = query != null && query.getCount() > 0;
        n.e(query);
        return z;
    }

    public static void a(com.baidu.tieba.frs.f fVar, int i, String[] strArr, int[] iArr) {
        if (fVar != null && strArr != null && iArr != null && i == 1) {
            if (ab.aK(TbadkCoreApplication.getInst().getApplicationContext())) {
                ai.c(fVar.getPageContext());
            } else {
                fVar.showToast(d.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                fVar.showToast(d.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static void B(com.baidu.tieba.frs.f fVar) {
        if (fVar != null && ax.aU(fVar.getActivity())) {
            TiebaStatic.log(new ak("c10177").ad("fid", fVar.getForumId()));
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(fVar.getPageContext().getPageActivity(), String.valueOf(fVar.getForumId()), false, 0)));
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, bh bhVar) {
        if (fVar != null && bhVar != null && ax.aU(fVar.getActivity())) {
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(fVar.getPageContext().getPageActivity()).createConfig(String.valueOf(fVar.getForumId()), bhVar.getTid(), 1)));
        }
    }

    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.i iVar) {
        if (tbPageContext != null && iVar != null) {
            com.baidu.tbadk.browser.a.a(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + iVar.aMZ().getId(), true, true, true);
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, String str, bh bhVar, boolean z) {
        if (fVar != null && bhVar != null && str != null) {
            if (!(bhVar == null || bhVar.sl())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, fVar.getForumName(), null, 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                createFromThreadCfg.setStartFrom(1);
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, fVar.getForumName(), null, 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setForumId(String.valueOf(bhVar.getFid()));
            createFromThreadCfg2.setStartFrom(1);
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, String str, bh bhVar, boolean z) {
        if (fVar != null && bhVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, fVar.getForumName(), null, 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
            createFromThreadCfg.setStartFrom(1);
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
                    com.baidu.tbadk.core.e.b.i(tbPageContext.getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.e.b.i(tbPageContext.getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, bh bhVar) {
        bf rc;
        if (fVar != null && bhVar != null && bhVar.rX() == 2 && (rc = bhVar.rc()) != null && MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(fVar.getPageContext().getPageActivity()).createNormalCfg(rc.getThreadId(), rc.getTaskId(), rc.getForumId(), rc.getForumName(), bhVar.rq(), bhVar.rr())));
        }
    }

    public static void c(com.baidu.tieba.frs.f fVar, bh bhVar) {
        PhotoLiveActivityConfig pj;
        if (fVar != null && bhVar != null) {
            if (bhVar.getThreadType() == 33 || (bhVar instanceof aw)) {
                if (bhVar.rR() > 0 && com.baidu.tieba.tbadkCore.util.f.bsw()) {
                    pj = new PhotoLiveActivityConfig.a(fVar.getPageContext().getPageActivity(), bhVar.getTid()).cu("from_frs").bF(18003).cs(String.valueOf(bhVar.rR())).pj();
                } else {
                    pj = new PhotoLiveActivityConfig.a(fVar.getPageContext().getPageActivity(), bhVar.getTid()).cu("from_frs").bF(18003).pj();
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pj));
            }
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, bh bhVar, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (fVar != null && bhVar != null) {
            if (bhVar.rR() > 0 && com.baidu.tieba.tbadkCore.util.f.bsw()) {
                createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createHistoryCfg(bhVar.getTid(), String.valueOf(bhVar.rR()), false, true, null);
            } else {
                createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, fVar.getForumName(), null, 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bhVar.sy());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
            createFromThreadCfg.setStartFrom(1);
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
