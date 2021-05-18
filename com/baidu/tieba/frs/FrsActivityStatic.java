package com.baidu.tieba.frs;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceSocketResponseMessage;
import com.baidu.tieba.frs.achievement.AchievementActivity;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.frs.dynamic.FrsDynamicHttpResponseMessage;
import com.baidu.tieba.frs.dynamic.FrsDynamicSocketResponsedMessage;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.frs.movearea.FrsMoveAreaResMsg;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import d.a.j0.z0.n0;
import d.a.j0.z0.o0;
import d.a.k0.q0.n2.m;
import d.a.k0.q0.s;
import d.a.k0.q0.t;
import d.a.k0.q0.w0;
import d.a.k0.s2.x;
import java.net.URLDecoder;
import java.util.Map;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes4.dex */
public class FrsActivityStatic {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15112a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f15113b = true;

    /* renamed from: c  reason: collision with root package name */
    public static String f15114c = "";

    /* renamed from: d  reason: collision with root package name */
    public static final CustomMessageListener f15115d = new g(2012111);

    /* renamed from: e  reason: collision with root package name */
    public static final CustomMessageListener f15116e = new h(2012112);

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<TbPageContext> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.k0.q0.k> run(CustomMessage<TbPageContext> customMessage) {
            if (customMessage == null || !(customMessage.getData() instanceof TbPageContext)) {
                return null;
            }
            return new CustomResponsedMessage<>(2921336, new s(customMessage.getData(), t.f59517f));
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            o0.a(d.a.k0.q0.m1.a.f58752i, StarTrendsResIdl.class);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements UrlManager.UrlSchemaHandler {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlSchemaHandler
        public void deal(TbPageContext<?> tbPageContext, Map<String, String> map) {
            if (tbPageContext == null || map == null) {
                return;
            }
            String str = map.get("forum_id");
            String str2 = map.get("from");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new ForumRulesShowActivityConfig(tbPageContext.getPageActivity(), str, str2).start();
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<FrsActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                int requestCode = customMessage.getData().getRequestCode();
                if (requestCode == 0) {
                    customMessage.getData().startActivity(FrsActivity.class);
                } else {
                    customMessage.getData().startActivityForResult(requestCode, FrsActivity.class);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable<FrsActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(FrsActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            String substring;
            boolean z;
            int d2;
            String str;
            if (strArr != null) {
                boolean z2 = false;
                if (strArr[0] != null && tbPageContext != null && tbPageContext.getPageActivity() != null) {
                    String lowerCase = strArr[0].toLowerCase();
                    String str2 = strArr.length > 1 ? strArr[1] : null;
                    int d3 = d.a.c.e.m.b.d(n0.c(lowerCase, "call_from="), 0);
                    if (!lowerCase.startsWith("http://tieba.baidu.com/f?") && !lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                        if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS)) {
                            r4 = lowerCase.substring(4);
                            d2 = 0;
                            z = true;
                        } else {
                            if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                                r4 = lowerCase.substring(25);
                                z2 = true;
                            } else if (lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kw=")) {
                                r4 = n0.c(lowerCase, "kw=");
                                if (!TextUtils.isEmpty(r4)) {
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(r4, str2);
                                    if (d3 > 0) {
                                        createNormalCfg.setCallFrom(d3);
                                    } else {
                                        createNormalCfg.setCallFrom(12);
                                    }
                                    if (lowerCase.contains(TbConfig.WEB_VIEW_NEED_FRESH)) {
                                        createNormalCfg.setRequestCode(25045);
                                    }
                                    tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    return 0;
                                }
                            } else if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_GAME_FRS_TAB)) {
                                r4 = n0.c(lowerCase, "kw=");
                                d2 = d.a.c.e.m.b.d(n0.c(lowerCase, "tab_id="), 0);
                                z = false;
                            } else if (lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_FRS)) {
                                Uri parse = Uri.parse(lowerCase);
                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parse != null ? parse.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME) : null, str2);
                                if (lowerCase.contains("achievement")) {
                                    createNormalCfg2.setAchievementUrl(lowerCase);
                                }
                                tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                return 0;
                            } else {
                                return 3;
                            }
                            d2 = 0;
                            z = false;
                        }
                    } else {
                        if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            substring = lowerCase.substring(25);
                        } else {
                            substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring(25) : null;
                        }
                        if (substring != null) {
                            String[] split = substring.split("&");
                            int i2 = 0;
                            while (true) {
                                if (i2 >= split.length) {
                                    str = null;
                                    z = false;
                                    break;
                                } else if (split[i2] != null && split[i2].startsWith("kw=")) {
                                    str = split[i2].substring(3);
                                    z = true;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (!TextUtils.isEmpty(str)) {
                                r4 = URLDecoder.decode(str);
                            }
                        } else {
                            z = false;
                        }
                        d2 = d.a.c.e.m.b.d(n0.c(lowerCase, "default_tab_id="), 0);
                    }
                    if (!TextUtils.isEmpty(r4)) {
                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(r4, str2);
                        if (d2 != 0) {
                            createNormalCfg3.setDefaultGameTabId(d2);
                        }
                        if (d3 > 0) {
                            createNormalCfg3.setCallFrom(d3);
                        } else {
                            createNormalCfg3.setCallFrom(12);
                        }
                        tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                        return 1;
                    } else if (z2 && !TextUtils.isEmpty(r4)) {
                        d.a.c.e.m.f.c(TbadkCoreApplication.getInst(), m.c(TbadkCoreApplication.getInst(), r4));
                        d.a.k0.q0.n2.l.e(lowerCase, 2, 2);
                        return 1;
                    } else if (z) {
                        tbPageContext.showToast(R.string.page_not_found);
                        return 1;
                    }
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
                int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
                if (intValue != 1 && intValue != 4 && intValue != 3 && intValue != 2) {
                    FrsActivityStatic.f15113b = false;
                    FrsActivityStatic.f15112a = false;
                    return;
                }
                FrsActivityStatic.f15113b = true;
                FrsActivityStatic.f15112a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            int d2 = d.a.c.e.m.b.d(customResponsedMessage.getData().toString(), 1);
            if (d2 == 1 || d2 == 0) {
                FrsActivityStatic.f15113b = false;
                FrsActivityStatic.f15112a = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
                if (x.p().b() != null) {
                    x.p().b().f();
                }
                if (x.p().o() != null) {
                    x.p().o().c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getCmd() == 2016501 && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                d.a.k0.q0.n2.k.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements d.a.j0.d.e {
        @Override // d.a.j0.d.e
        public View a(Context context) {
            TextView a2 = d.a.j0.d.d.a(context);
            if (a2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                SkinManager.setViewTextColor(a2, R.color.CAM_X0302);
                layoutParams.setMargins(d.a.c.e.p.l.g(context, R.dimen.ds8), 0, d.a.c.e.p.l.g(context, R.dimen.ds8), 0);
                layoutParams.gravity = 16;
                a2.setLayoutParams(layoutParams);
            }
            return a2;
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            o0.a(d.a.k0.d3.m.WIRE, FrsPageResIdl.class);
            return null;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ForumRuleEditActivityConfig.class, ForumRulesEditActivity.class);
        a();
        c();
        d();
        b();
        l();
        e();
        LocationModel.C();
        j();
        i();
        f();
        o();
        MessageManager.getInstance().registerListener(f15115d);
        MessageManager.getInstance().registerListener(f15116e);
        h();
        m();
        n();
        k();
        TbadkCoreApplication.getInst().RegisterIntent(ForumRulesShowActivityConfig.class, ForumRulesShowActivity.class);
        g();
        SwitchManager.getInstance().registerSwitch(w0.class);
    }

    public static void a() {
        d.a.j0.d.c.b().c(1, new k());
    }

    public static void b() {
        UrlManager.getInstance().addListener(new f());
    }

    public static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        TbadkApplication.getInst().RegisterIntent(AchievementActivityConfig.class, AchievementActivity.class);
    }

    public static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new e());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void e() {
        MessageManager.getInstance().registerListener(new j(2016501));
    }

    public static void f() {
        d.a.k0.d3.d0.a.h(309602, FrsDynamicSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_DYNAMIC, d.a.k0.d3.d0.a.a(TbConfig.FRS_DYNAMIC_ADDRESS, 309602));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsDynamicHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        b bVar = new b();
        bVar.setSelfExecute(true);
        bVar.setPriority(4);
        bVar.execute(new Void[0]);
    }

    public static void g() {
        UrlManager.getInstance().registerSchema(UrlSchemaHelper.SCHEMA_TYPE_FRS_RULES, new c());
    }

    public static void h() {
        d.a.k0.d3.d0.a.f(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, d.a.k0.d3.d0.a.a(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void i() {
        d.a.k0.d3.d0.a.h(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, d.a.k0.d3.d0.a.a(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        l lVar = new l();
        lVar.setSelfExecute(true);
        lVar.setPriority(4);
        lVar.execute(new Void[0]);
    }

    public static void j() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921336, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void k() {
        d.a.k0.d3.d0.a.h(309667, GetLiveHorseRaceSocketResponseMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309667, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, TbConfig.URL_FRS_LIVE_HORSERACE_LIST, GetLiveHorseRaceHttpResponseMessage.class, true, false, true, false);
    }

    public static void l() {
        MessageManager.getInstance().registerListener(new i(2001012));
    }

    public static void m() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_MOVE_AREA, TbConfig.SERVER_ADDRESS + TbConfig.URL_FRS_MOVE_AREA);
        tbHttpMessageTask.setResponsedClass(FrsMoveAreaResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void n() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_RECOMMEND, TbConfig.SERVER_ADDRESS + TbConfig.URL_FRS_RECOMMEND);
        tbHttpMessageTask.setResponsedClass(FrsRecommendResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void o() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
        tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
