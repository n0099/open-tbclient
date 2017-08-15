package com.baidu.tieba.frs.f;

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
import com.baidu.adp.lib.util.m;
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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    public static String O(Intent intent) {
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
                TiebaStatic.log(new aj("c10320").r("obj_locate", 2).r("obj_type", 1));
            }
            return matcher.group(2);
        }
        TiebaStatic.log(new aj("c10320").r("obj_locate", 2).r("obj_type", 1));
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

    public static void c(ListView listView) {
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
        Cursor query = context.getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{str + context.getString(d.l.bar)}, null);
        boolean z = query != null && query.getCount() > 0;
        m.e(query);
        return z;
    }

    public static void a(com.baidu.tieba.frs.f fVar, int i, String[] strArr, int[] iArr) {
        if (fVar != null && strArr != null && iArr != null && i == 1) {
            if (aa.aE(TbadkCoreApplication.getInst().getApplicationContext())) {
                ah.c(fVar.getPageContext());
            } else {
                fVar.showToast(d.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = aa.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                fVar.showToast(d.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static void B(com.baidu.tieba.frs.f fVar) {
        if (fVar != null && aw.aO(fVar.getActivity())) {
            TiebaStatic.log(new aj("c10177").aa("fid", fVar.getForumId()));
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(fVar.getPageContext().getPageActivity(), String.valueOf(fVar.getForumId()), false, 0)));
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, bl blVar) {
        if (fVar != null && blVar != null && aw.aO(fVar.getActivity())) {
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(fVar.getPageContext().getPageActivity()).createConfig(String.valueOf(fVar.getForumId()), blVar.getTid(), 1)));
        }
    }

    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.i iVar) {
        if (tbPageContext != null && iVar != null) {
            com.baidu.tbadk.browser.a.a(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + iVar.aPO().getId(), true, true, true);
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, String str, bl blVar, boolean z) {
        if (fVar != null && blVar != null && str != null) {
            if (!(blVar == null || blVar.sv())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, fVar.getForumName(), null, 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setForumId(String.valueOf(blVar.getFid()));
                createFromThreadCfg.setStartFrom(1);
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, fVar.getForumName(), null, 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setForumId(String.valueOf(blVar.getFid()));
            createFromThreadCfg2.setStartFrom(1);
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, String str, bl blVar, boolean z) {
        if (fVar != null && blVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, fVar.getForumName(), null, 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setForumId(String.valueOf(blVar.getFid()));
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

    public static void b(com.baidu.tieba.frs.f fVar, bl blVar) {
        bj rn;
        if (fVar != null && blVar != null && blVar.sh() == 2 && (rn = blVar.rn()) != null && MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(fVar.getPageContext().getPageActivity()).createNormalCfg(rn.getThreadId(), rn.getTaskId(), rn.getForumId(), rn.getForumName(), blVar.rA(), blVar.rB())));
        }
    }

    public static void c(com.baidu.tieba.frs.f fVar, bl blVar) {
        PhotoLiveActivityConfig pn;
        if (fVar != null && blVar != null) {
            if (blVar.getThreadType() == 33 || (blVar instanceof ay)) {
                if (blVar.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.bue()) {
                    pn = new PhotoLiveActivityConfig.a(fVar.getPageContext().getPageActivity(), blVar.getTid()).cB("from_frs").bB(18003).cz(String.valueOf(blVar.sb())).pn();
                } else {
                    pn = new PhotoLiveActivityConfig.a(fVar.getPageContext().getPageActivity(), blVar.getTid()).cB("from_frs").bB(18003).pn();
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pn));
            }
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, bl blVar, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (fVar != null && blVar != null) {
            if (blVar.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.bue()) {
                createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createHistoryCfg(blVar.getTid(), String.valueOf(blVar.sb()), false, true, null);
            } else {
                createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(blVar, fVar.getForumName(), null, 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(blVar.sI());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(String.valueOf(blVar.getFid()));
            createFromThreadCfg.setStartFrom(1);
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
