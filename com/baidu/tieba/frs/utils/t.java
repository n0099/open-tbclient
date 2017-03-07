package com.baidu.tieba.frs.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.w;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class t {
    public static String I(Intent intent) {
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
                TiebaStatic.log(new as("c10320").s("obj_locate", 2).s("obj_type", 1));
            }
            return matcher.group(2);
        }
        TiebaStatic.log(new as("c10320").s("obj_locate", 2).s("obj_type", 1));
        int indexOf = decode.indexOf("kw=");
        if (indexOf < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public static Intent ae(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static void l(ax axVar) {
        try {
            if ("OPPO".equals(Build.MANUFACTURER) && axVar.Zo() != null) {
                Method declaredMethod = AbsListView.class.getDeclaredMethod("trackMotionScroll", Integer.TYPE, Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(axVar.getListView(), 500, 10);
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void d(ListView listView) {
        Object d;
        if (listView != null && (d = com.baidu.adp.lib.OrmObject.a.a.d(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.OrmObject.a.a.a("clear", d, d.getClass());
        }
    }

    public static Intent af(Context context, String str) {
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
    public static boolean ag(Context context, String str) {
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

    public static boolean ah(Context context, String str) {
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

    public static void a(FrsActivity frsActivity, int i, String[] strArr, int[] iArr) {
        if (frsActivity != null && strArr != null && iArr != null && i == 1) {
            if (ae.ay(frsActivity.getApplicationContext())) {
                ap.c(frsActivity.getPageContext());
            } else {
                frsActivity.showToast(w.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ae.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                frsActivity.showToast(w.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static void E(FrsActivity frsActivity) {
        if (frsActivity != null && frsActivity.checkUpIsLogin()) {
            TiebaStatic.log(new as("c10177").Z("fid", frsActivity.getForumId()));
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(frsActivity.getPageContext().getPageActivity(), String.valueOf(frsActivity.getForumId()), false, 0)));
        }
    }

    public static void b(FrsActivity frsActivity, bj bjVar) {
        if (frsActivity != null && bjVar != null && frsActivity.checkUpIsLogin()) {
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(frsActivity.getPageContext().getPageActivity()).createConfig(String.valueOf(frsActivity.getForumId()), bjVar.getTid(), 1)));
        }
    }

    public static void b(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar) {
        if (frsActivity != null && nVar != null) {
            com.baidu.tbadk.browser.f.a(frsActivity.getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + nVar.aJp().getId(), true, true, true);
        }
    }

    public static void g(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
            if (nVar != null && nVar.aJp() != null) {
                eVar.setForumId(com.baidu.adp.lib.g.b.c(nVar.aJp().getId(), 0L));
                eVar.eN(nVar.aJp().getName());
                eVar.eO(nVar.aJp().getImage_url());
                eVar.en(nVar.aJp().getSigned() ? 1 : 0);
                eVar.em(nVar.aJp().getUser_level());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM, eVar));
        }
    }

    public static void a(FrsActivity frsActivity, String str, bj bjVar, boolean z) {
        if (frsActivity != null && bjVar != null && str != null) {
            if (!(bjVar == null || bjVar.sG())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, frsActivity.getForumName(), null, 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, frsActivity.getForumName(), null, 18003, false, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(FrsActivity frsActivity, String str, bj bjVar, boolean z) {
        if (frsActivity != null && bjVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, frsActivity.getForumName(), null, 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(FrsActivity frsActivity, Intent intent, String str) {
        if (frsActivity != null) {
            if (intent != null && !intent.getBooleanExtra("back_special", false)) {
                frsActivity.finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(frsActivity.getPageContext().getPageActivity()).createNormalCfg(1)));
                } else {
                    com.baidu.tbadk.core.e.b.i(frsActivity.getPageContext().getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(frsActivity.getPageContext().getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.e.b.i(frsActivity.getPageContext().getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                frsActivity.finish();
            }
        }
    }

    public static void c(FrsActivity frsActivity, bj bjVar) {
        bh rz;
        if (frsActivity != null && bjVar != null && bjVar.ss() == 2 && (rz = bjVar.rz()) != null && MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(frsActivity.getPageContext().getPageActivity()).createNormalCfg(rz.getThreadId(), rz.getTaskId(), rz.getForumId(), rz.getForumName(), bjVar.rM(), bjVar.rN())));
        }
    }

    public static void d(FrsActivity frsActivity, bj bjVar) {
        PhotoLiveActivityConfig pg;
        if (frsActivity != null && bjVar != null) {
            if (bjVar.getThreadType() == 33 || (bjVar instanceof com.baidu.tbadk.core.data.ax)) {
                if (bjVar.sm() > 0 && com.baidu.tieba.tbadkCore.util.s.biB()) {
                    pg = new PhotoLiveActivityConfig.a(frsActivity.getPageContext().getPageActivity(), bjVar.getTid()).cd("from_frs").bz(18003).cb(String.valueOf(bjVar.sm())).pg();
                } else {
                    pg = new PhotoLiveActivityConfig.a(frsActivity.getPageContext().getPageActivity(), bjVar.getTid()).cd("from_frs").bz(18003).pg();
                }
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pg));
            }
        }
    }

    public static void a(FrsActivity frsActivity, bj bjVar, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (frsActivity != null && bjVar != null) {
            if (bjVar.sm() > 0 && com.baidu.tieba.tbadkCore.util.s.biB()) {
                createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.sm()), false, true, null);
            } else {
                createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, frsActivity.getForumName(), null, 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.sT());
            createFromThreadCfg.setSmartFrsPosition(i);
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
