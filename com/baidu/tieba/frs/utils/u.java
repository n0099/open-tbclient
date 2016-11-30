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
import com.baidu.tbadk.core.atomData.EcommProductListActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveHeadlineActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveListActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.r;
import java.lang.reflect.Method;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u {
    public static String k(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new av("c10320").s("obj_locate", 2).s("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public static Intent J(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static void q(au auVar) {
        try {
            if ("OPPO".equals(Build.MANUFACTURER) && auVar.acM() != null) {
                Method declaredMethod = AbsListView.class.getDeclaredMethod("trackMotionScroll", Integer.TYPE, Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(auVar.acW(), 500, 10);
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void d(ListView listView) {
        Object d;
        if (listView != null && (d = com.baidu.adp.lib.a.a.a.d(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", d, d.getClass());
        }
    }

    public static Intent K(Context context, String str) {
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
    public static boolean L(Context context, String str) {
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

    public static boolean M(Context context, String str) {
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
        Cursor query = context.getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{String.valueOf(str) + context.getString(r.j.bar)}, null);
        boolean z = query != null && query.getCount() > 0;
        com.baidu.adp.lib.util.o.a(query);
        return z;
    }

    public static void a(FrsActivity frsActivity, int i, String[] strArr, int[] iArr) {
        if (frsActivity != null && strArr != null && iArr != null && i == 1) {
            if (ae.aa(frsActivity.getApplicationContext())) {
                as.c(frsActivity.getPageContext());
            } else {
                frsActivity.showToast(r.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ae.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                frsActivity.showToast(r.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public static void E(FrsActivity frsActivity) {
        if (frsActivity != null && frsActivity.checkUpIsLogin()) {
            TiebaStatic.log(new av("c10177").ab("fid", frsActivity.getForumId()));
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(frsActivity.getPageContext().getPageActivity(), String.valueOf(frsActivity.getForumId()), false, 0)));
        }
    }

    public static void b(FrsActivity frsActivity, bk bkVar) {
        if (frsActivity != null && bkVar != null && frsActivity.checkUpIsLogin()) {
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(frsActivity.getPageContext().getPageActivity()).createConfig(String.valueOf(frsActivity.getForumId()), bkVar.getTid(), 1)));
        }
    }

    public static void b(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar) {
        if (frsActivity != null && pVar != null) {
            com.baidu.tbadk.browser.f.a(frsActivity.getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + pVar.aOk().getId(), true, true, true);
        }
    }

    public static void h(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
            if (pVar != null && pVar.aOk() != null) {
                eVar.setForumId(com.baidu.adp.lib.h.b.c(pVar.aOk().getId(), 0L));
                eVar.ff(pVar.aOk().getName());
                eVar.fg(pVar.aOk().getImage_url());
                eVar.eq(pVar.aOk().getSigned() ? 1 : 0);
                eVar.ep(pVar.aOk().getUser_level());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM, eVar));
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, com.baidu.tieba.frs.e.i iVar) {
        if (frsActivity != null && pVar != null && iVar != null) {
            int i = 0;
            if (pVar.getUserData() != null) {
                i = pVar.getUserData().getIsMem();
            }
            EcommProductListActivityConfig ecommProductListActivityConfig = new EcommProductListActivityConfig(frsActivity.getPageContext().getPageActivity(), 7, pVar.aOk().getId(), frsActivity.getForumName(), null, null, 0, pVar.qs(), 13003, false, false, null, false, false, null, null, pVar.aOk().getPrefixData(), i, "");
            ecommProductListActivityConfig.addEcommAddress(frsActivity.aca());
            if (bx.adE().hY(1) != null) {
                ecommProductListActivityConfig.setCategroyId(iVar.agq());
            }
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommProductListActivityConfig));
        }
    }

    public static com.baidu.tieba.frs.ecomm.a F(FrsActivity frsActivity) {
        com.baidu.tieba.frs.ecomm.a aVar = new com.baidu.tieba.frs.ecomm.a(frsActivity);
        aVar.a(new v(frsActivity));
        return aVar;
    }

    public static void a(FrsActivity frsActivity, String str, bk bkVar, boolean z) {
        if (frsActivity != null && bkVar != null && str != null) {
            if (!(bkVar == null || bkVar.sE())) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, frsActivity.getForumName(), null, 18003, true, true, z);
                createFromThreadCfg.setVideo_source("frs");
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, frsActivity.getForumName(), null, 18003, false, false, z);
            createFromThreadCfg2.setVideo_source("frs");
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    public static void b(FrsActivity frsActivity, String str, bk bkVar, boolean z) {
        if (frsActivity != null && bkVar != null && str != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, frsActivity.getForumName(), null, 18003, false, false, z);
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
                    com.baidu.tbadk.core.d.b.f(frsActivity.getPageContext().getPageActivity(), 1);
                }
            } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(frsActivity.getPageContext().getPageActivity()).createNormalCfg(2)));
            } else {
                com.baidu.tbadk.core.d.b.f(frsActivity.getPageContext().getPageActivity(), 2);
            }
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                frsActivity.finish();
            }
        }
    }

    public static void c(FrsActivity frsActivity, bk bkVar) {
        bi rz;
        if (frsActivity != null && bkVar != null && bkVar.sq() == 2 && (rz = bkVar.rz()) != null && MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(frsActivity.getPageContext().getPageActivity()).createNormalCfg(rz.getThreadId(), rz.getTaskId(), rz.getForumId(), rz.getForumName(), bkVar.rL(), bkVar.rM())));
        }
    }

    public static void d(FrsActivity frsActivity, bk bkVar) {
        PhotoLiveActivityConfig oZ;
        if (frsActivity != null && bkVar != null) {
            if (bkVar.getThreadType() == 33 || (bkVar instanceof com.baidu.tbadk.core.data.av)) {
                if (bkVar.sj() > 0 && com.baidu.tieba.tbadkCore.util.s.bng()) {
                    oZ = new PhotoLiveActivityConfig.a(frsActivity.getPageContext().getPageActivity(), bkVar.getTid()).cl("from_frs").bF(18003).cj(String.valueOf(bkVar.sj())).oZ();
                } else {
                    oZ = new PhotoLiveActivityConfig.a(frsActivity.getPageContext().getPageActivity(), bkVar.getTid()).cl("from_frs").bF(18003).oZ();
                }
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oZ));
            }
        }
    }

    public static void a(FrsActivity frsActivity, bk bkVar, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (frsActivity != null && bkVar != null) {
            if (bkVar.sj() > 0 && com.baidu.tieba.tbadkCore.util.s.bng()) {
                createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createHistoryCfg(bkVar.getTid(), String.valueOf(bkVar.sj()), false, true, null);
            } else {
                createFromThreadCfg = new PbActivityConfig(frsActivity.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, frsActivity.getForumName(), null, 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
