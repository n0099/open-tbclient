package com.baidu.tieba.frs.e;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveHeadlineActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveListActivityConfig;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p {
    public static String L(Intent intent) {
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
                TiebaStatic.log(new as("c10320").r("obj_locate", 2).r("obj_type", 1));
            }
            return matcher.group(2);
        }
        TiebaStatic.log(new as("c10320").r("obj_locate", 2).r("obj_type", 1));
        int indexOf = decode.indexOf("kw=");
        if (indexOf < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public static Intent ag(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static void c(ListView listView) {
        Object d;
        if (listView != null && (d = com.baidu.adp.lib.OrmObject.a.a.d(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.OrmObject.a.a.a("clear", d, d.getClass());
        }
    }

    public static Intent ah(Context context, String str) {
        Class<?> intentClass;
        if (str == null || str.length() <= 0 || (intentClass = TbadkCoreApplication.m9getInst().getIntentClass(LogoActivityConfig.class)) == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean ai(Context context, String str) {
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
    }

    public static boolean aj(Context context, String str) {
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
        Cursor query = context.getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{String.valueOf(str) + context.getString(w.l.bar)}, null);
        boolean z = query != null && query.getCount() > 0;
        com.baidu.adp.lib.util.o.a(query);
        return z;
    }

    public static void a(com.baidu.tieba.frs.r rVar, int i, String[] strArr, int[] iArr) {
        if (rVar != null && strArr != null && iArr != null && i == 1) {
            if (ae.aD(rVar.getActivity().getApplicationContext())) {
                ap.c(rVar.getPageContext());
            } else {
                rVar.showToast(w.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ae.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                rVar.showToast(w.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static void y(com.baidu.tieba.frs.r rVar) {
        if (rVar != null && bh.aN(rVar.getActivity())) {
            TiebaStatic.log(new as("c10177").Z("fid", rVar.getForumId()));
            rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(rVar.getPageContext().getPageActivity(), String.valueOf(rVar.getForumId()), false, 0)));
        }
    }

    public static void a(com.baidu.tieba.frs.r rVar, bl blVar) {
        if (rVar != null && blVar != null && bh.aN(rVar.getActivity())) {
            rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(rVar.getPageContext().getPageActivity()).createConfig(String.valueOf(rVar.getForumId()), blVar.getTid(), 1)));
        }
    }

    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar) {
        if (tbPageContext != null && nVar != null) {
            com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + nVar.aIz().getId(), true, true, true);
        }
    }

    public static void a(com.baidu.tieba.frs.r rVar, String str, bl blVar, boolean z) {
        if (rVar != null && blVar != null && str != null) {
            if (!(blVar == null || blVar.sk())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(rVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, rVar.getForumName(), null, 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setForumId(String.valueOf(blVar.getFid()));
                createFromThreadCfg.setStartFrom(1);
                rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(rVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, rVar.getForumName(), null, 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setForumId(String.valueOf(blVar.getFid()));
            createFromThreadCfg2.setStartFrom(1);
            rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(com.baidu.tieba.frs.r rVar, String str, bl blVar, boolean z) {
        if (rVar != null && blVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(rVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, rVar.getForumName(), null, 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setForumId(String.valueOf(blVar.getFid()));
            createFromThreadCfg.setStartFrom(1);
            rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
                    com.baidu.tbadk.core.f.b.i(tbPageContext.getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.f.b.i(tbPageContext.getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public static void b(com.baidu.tieba.frs.r rVar, bl blVar) {
        bj rd;
        if (rVar != null && blVar != null && blVar.rW() == 2 && (rd = blVar.rd()) != null && MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(rVar.getPageContext().getPageActivity()).createNormalCfg(rd.getThreadId(), rd.getTaskId(), rd.getForumId(), rd.getForumName(), blVar.rq(), blVar.rr())));
        }
    }

    public static void c(com.baidu.tieba.frs.r rVar, bl blVar) {
        PhotoLiveActivityConfig pd;
        if (rVar != null && blVar != null) {
            if (blVar.getThreadType() == 33 || (blVar instanceof ay)) {
                if (blVar.rQ() > 0 && com.baidu.tieba.tbadkCore.util.s.bje()) {
                    pd = new PhotoLiveActivityConfig.a(rVar.getPageContext().getPageActivity(), blVar.getTid()).ck("from_frs").bA(18003).ci(String.valueOf(blVar.rQ())).pd();
                } else {
                    pd = new PhotoLiveActivityConfig.a(rVar.getPageContext().getPageActivity(), blVar.getTid()).ck("from_frs").bA(18003).pd();
                }
                rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pd));
            }
        }
    }

    public static void a(com.baidu.tieba.frs.r rVar, bl blVar, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (rVar != null && blVar != null) {
            if (blVar.rQ() > 0 && com.baidu.tieba.tbadkCore.util.s.bje()) {
                createFromThreadCfg = new PbActivityConfig(rVar.getPageContext().getPageActivity()).createHistoryCfg(blVar.getTid(), String.valueOf(blVar.rQ()), false, true, null);
            } else {
                createFromThreadCfg = new PbActivityConfig(rVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, rVar.getForumName(), null, 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(blVar.sw());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(String.valueOf(blVar.getFid()));
            createFromThreadCfg.setStartFrom(1);
            rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
