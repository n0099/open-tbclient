package com.baidu.tieba.ala.alasquare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.AlaAllLiveSimpleActivity;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYYSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListActivity;
import d.a.k0.q0.j0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class AlaSquareDelegateStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof j0) {
                j0 j0Var = (j0) data;
                j0Var.a(new d.a.k0.t.d.f.a(j0Var.d(), j0Var.e()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            return new CustomResponsedMessage<>(2911006, d.a.j0.r.d0.b.j().p("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播"));
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            return new CustomResponsedMessage<>(2911008, d.a.j0.r.d0.b.j().p("show_live_forum_name", "百度直播"));
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length != 0 && strArr[0] != null && tbPageContext != null) {
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains(UrlSchemaHelper.JUMP_TO_VIDEO_SQUARE)) {
                    d.a.j0.r.a0.b.f(tbPageContext.getPageActivity(), 15, true);
                    return 1;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/video/square\\?tid=(\\d+)").matcher(lowerCase);
                if (matcher.find()) {
                    if (AlaSquareDelegateStatic.c()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2).buildVideoThreadId(matcher.group(1))));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(15).buildVideoThreadId(matcher.group(1))));
                    }
                    return 1;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(AlaAllLiveSimpleActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.k0.q0.g gVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.k0.q0.g) || (gVar = (d.a.k0.q0.g) customResponsedMessage.getData()) == null || ListUtils.isEmpty(gVar.e())) {
                return;
            }
            for (FrsTabInfo frsTabInfo : gVar.e()) {
                if (frsTabInfo.tab_id.intValue() == 1120) {
                    AlaSquareDelegateStatic.b(gVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends d.a.j0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.q0.g f13750a;

        public g(d.a.k0.q0.g gVar) {
            this.f13750a = gVar;
        }

        @Override // d.a.j0.e0.b
        public d.a.j0.e0.c createFragmentTabStructure() {
            LiveTabYYSubFragment W0 = LiveTabYYSubFragment.W0(true, 2);
            W0.H0(this.f13750a.b(), this.f13750a.c());
            d.a.j0.e0.c cVar = new d.a.j0.e0.c();
            cVar.f49290a = W0;
            cVar.f49294e = 1120;
            cVar.f49298i = d.a.j0.e0.c.k;
            return cVar;
        }

        @Override // d.a.j0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.a.j0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a extends d.a.j0.e0.b {
            public a(h hVar) {
            }

            @Override // d.a.j0.e0.b
            public d.a.j0.e0.c createFragmentTabStructure() {
                d.a.j0.e0.c cVar = new d.a.j0.e0.c();
                cVar.f49290a = new MainBottomLiveTabFragment();
                cVar.f49294e = 20;
                cVar.f49291b = R.string.ala_live;
                cVar.f49295f = R.raw.lottie_tab_live;
                cVar.f49298i = d.a.j0.e0.c.l;
                return cVar;
            }

            @Override // d.a.j0.e0.b
            public TbFragmentTabIndicator getTabIndicator(Context context) {
                MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
                this.mIndicator = maintabBottomIndicator;
                return maintabBottomIndicator;
            }

            @Override // d.a.j0.e0.b
            public boolean isAvailable() {
                return true;
            }
        }

        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            ((d.a.j0.e0.d) customResponsedMessage.getData()).a(new a(this));
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements CustomMessageTask.CustomRunnable<BaseFragment> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<BaseFragment> run(CustomMessage<BaseFragment> customMessage) {
            return new CustomResponsedMessage<>(2921399, new AlaLiveTabFragment());
        }
    }

    static {
        j();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921353));
        g();
        h();
        i();
        TbadkCoreApplication.getInst().RegisterIntent(AlaLiveTabMyConcernActivityConfig.class, AlaLiveTabMyConcernActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaNewSquareSubListActivityConfig.class, AlaNewSquareSubListActivity.class);
        l();
        f();
        d();
        MessageManager.getInstance().registerListener(new a(2001616));
        e();
        k();
        CustomMessageTask customMessageTask = new CustomMessageTask(2911006, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2911008, new c());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    public static void b(d.a.k0.q0.g gVar) {
        if (gVar != null) {
            gVar.a(new g(gVar));
        }
    }

    public static boolean c() {
        return true;
    }

    public static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new e());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void e() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_CONCERN_TAB);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSpecialConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void f() {
        f fVar = new f(2001623);
        fVar.setPriority(1);
        MessageManager.getInstance().registerListener(fVar);
    }

    public static void g() {
        new h(2007002).setPriority(6);
    }

    public static void h() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921399, new i());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void i() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_TAB_LIVE_INFO);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaTabLiveResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void j() {
        UrlManager.getInstance().addListener(new d());
    }

    public static void k() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_RECOMMEND_TAB);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaSpecialRecommendResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_NEW_SQUARE_SUB_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaNewSquareSubListResponseMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
