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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.m;
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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    private static void kY(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> ea = au.ea(str);
        if (ea != null) {
            TiebaStatic.log(new ak("c10320").ad("obj_locate", ea.get("obj_locate")).r("obj_type", 1).ad(ImageViewerConfig.FORUM_NAME, ea.get("kw")).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ea.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)).ad("obj_param2", ea.get("obj_param2")).r("obj_to", 2));
        }
    }

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
                kY(decode);
            }
            return matcher.group(2);
        }
        kY(decode);
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
        m.e(query);
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

    public static void A(com.baidu.tieba.frs.f fVar) {
        if (fVar != null && ax.aU(fVar.getActivity())) {
            TiebaStatic.log(new ak("c10177").ad("fid", fVar.getForumId()));
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(fVar.getPageContext().getPageActivity(), String.valueOf(fVar.getForumId()), false, 0)));
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, bj bjVar) {
        if (fVar != null && bjVar != null && ax.aU(fVar.getActivity())) {
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(fVar.getPageContext().getPageActivity()).createConfig(String.valueOf(fVar.getForumId()), bjVar.getTid(), 1)));
        }
    }

    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.i iVar) {
        if (tbPageContext != null && iVar != null) {
            com.baidu.tbadk.browser.a.a(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + iVar.aPg().getId(), true, true, true);
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, String str, bj bjVar, boolean z) {
        if (fVar != null && bjVar != null && str != null) {
            if (!(bjVar == null || bjVar.sr())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, fVar.getForumName(), null, 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                createFromThreadCfg.setStartFrom(1);
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, fVar.getForumName(), null, 18003, true, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            createFromThreadCfg2.setForumId(String.valueOf(bjVar.getFid()));
            createFromThreadCfg2.setStartFrom(1);
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, String str, bj bjVar, boolean z) {
        if (fVar != null && bjVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, fVar.getForumName(), null, 18003, false, false, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
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

    public static void b(com.baidu.tieba.frs.f fVar, bj bjVar) {
        bh ri;
        if (fVar != null && bjVar != null && bjVar.sd() == 2 && (ri = bjVar.ri()) != null && MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(fVar.getPageContext().getPageActivity()).createNormalCfg(ri.getThreadId(), ri.getTaskId(), ri.getForumId(), ri.getForumName(), bjVar.rw(), bjVar.rx())));
        }
    }

    public static void c(com.baidu.tieba.frs.f fVar, bj bjVar) {
        PhotoLiveActivityConfig pi;
        if (fVar != null && bjVar != null) {
            if (bjVar.getThreadType() == 33 || (bjVar instanceof ay)) {
                if (bjVar.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btx()) {
                    pi = new PhotoLiveActivityConfig.a(fVar.getPageContext().getPageActivity(), bjVar.getTid()).cu("from_frs").bB(18003).cs(String.valueOf(bjVar.rX())).pi();
                } else {
                    pi = new PhotoLiveActivityConfig.a(fVar.getPageContext().getPageActivity(), bjVar.getTid()).cu("from_frs").bB(18003).pi();
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pi));
            }
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, bj bjVar, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (fVar != null && bjVar != null) {
            if (bjVar.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btx()) {
                createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createHistoryCfg(bjVar.getTid(), String.valueOf(bjVar.rX()), false, true, null);
            } else {
                createFromThreadCfg = new PbActivityConfig(fVar.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, fVar.getForumName(), null, 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bjVar.sE());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
            createFromThreadCfg.setStartFrom(1);
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
