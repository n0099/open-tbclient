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
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.SdkLiveInfoListResponsedMessage;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListActivity;
import d.b.i0.q0.j0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class AlaSquareDelegateStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<BaseFragment> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<BaseFragment> run(CustomMessage<BaseFragment> customMessage) {
            return new CustomResponsedMessage<>(2921399, new AlaLiveTabFragment());
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
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
                j0Var.a(new d.b.i0.t.d.f.a(j0Var.d(), j0Var.e()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            return new CustomResponsedMessage<>(2911006, d.b.h0.r.d0.b.j().p("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播"));
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            return new CustomResponsedMessage<>(2911008, d.b.h0.r.d0.b.j().p("show_live_forum_name", "百度直播"));
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length != 0 && strArr[0] != null && tbPageContext != null) {
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains(UrlSchemaHelper.JUMP_TO_VIDEO_SQUARE)) {
                    d.b.h0.r.a0.b.f(tbPageContext.getPageActivity(), 15, true);
                    return 1;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/video/square\\?tid=(\\d+)").matcher(lowerCase);
                if (matcher.find()) {
                    if (AlaSquareDelegateStatic.e()) {
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
    public static class f implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(AlaAllLiveSimpleActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.q0.g gVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.q0.g) || (gVar = (d.b.i0.q0.g) customResponsedMessage.getData()) == null || ListUtils.isEmpty(gVar.e())) {
                return;
            }
            for (FrsTabInfo frsTabInfo : gVar.e()) {
                if (frsTabInfo.tab_id.intValue() == 1120) {
                    AlaSquareDelegateStatic.d(gVar);
                } else if (frsTabInfo.tab_id.intValue() == 1121) {
                    AlaSquareDelegateStatic.c(gVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends d.b.h0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.q0.g f14368a;

        public h(d.b.i0.q0.g gVar) {
            this.f14368a = gVar;
        }

        @Override // d.b.h0.e0.b
        public d.b.h0.e0.c createFragmentTabStructure() {
            LiveTabGameSubFragment S0 = LiveTabGameSubFragment.S0(true);
            S0.I0(this.f14368a.b(), this.f14368a.c());
            d.b.h0.e0.c cVar = new d.b.h0.e0.c();
            cVar.f50548a = S0;
            cVar.f50552e = 1121;
            cVar.i = d.b.h0.e0.c.k;
            return cVar;
        }

        @Override // d.b.h0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.b.h0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends d.b.h0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.q0.g f14369a;

        public i(d.b.i0.q0.g gVar) {
            this.f14369a = gVar;
        }

        @Override // d.b.h0.e0.b
        public d.b.h0.e0.c createFragmentTabStructure() {
            LiveTabYanzhiSubFragment S0 = LiveTabYanzhiSubFragment.S0(true);
            S0.I0(this.f14369a.b(), this.f14369a.c());
            d.b.h0.e0.c cVar = new d.b.h0.e0.c();
            cVar.f50548a = S0;
            cVar.f50552e = 1120;
            cVar.i = d.b.h0.e0.c.k;
            return cVar;
        }

        @Override // d.b.h0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.b.h0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a extends d.b.h0.e0.b {
            public a(j jVar) {
            }

            @Override // d.b.h0.e0.b
            public d.b.h0.e0.c createFragmentTabStructure() {
                d.b.h0.e0.c cVar = new d.b.h0.e0.c();
                cVar.f50548a = new MainBottomLiveTabFragment();
                cVar.f50552e = 20;
                cVar.f50549b = R.string.ala_live;
                cVar.f50553f = R.raw.lottie_tab_live;
                cVar.i = d.b.h0.e0.c.l;
                return cVar;
            }

            @Override // d.b.h0.e0.b
            public TbFragmentTabIndicator getTabIndicator(Context context) {
                MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
                this.mIndicator = maintabBottomIndicator;
                return maintabBottomIndicator;
            }

            @Override // d.b.h0.e0.b
            public boolean isAvailable() {
                return true;
            }
        }

        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            ((d.b.h0.e0.d) customResponsedMessage.getData()).a(new a(this));
        }
    }

    static {
        l();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921353));
        i();
        j();
        k();
        TbadkCoreApplication.getInst().RegisterIntent(AlaLiveTabMyConcernActivityConfig.class, AlaLiveTabMyConcernActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaNewSquareSubListActivityConfig.class, AlaNewSquareSubListActivity.class);
        o();
        n();
        h();
        f();
        MessageManager.getInstance().registerListener(new b(2001616));
        g();
        m();
        CustomMessageTask customMessageTask = new CustomMessageTask(2911006, new c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2911008, new d());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    public static void c(d.b.i0.q0.g gVar) {
        if (gVar != null) {
            gVar.a(new h(gVar));
        }
    }

    public static void d(d.b.i0.q0.g gVar) {
        if (gVar != null) {
            gVar.a(new i(gVar));
        }
    }

    public static boolean e() {
        return true;
    }

    public static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void g() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_CONCERN_TAB);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSpecialConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void h() {
        g gVar = new g(2001623);
        gVar.setPriority(1);
        MessageManager.getInstance().registerListener(gVar);
    }

    public static void i() {
        new j(2007002).setPriority(6);
    }

    public static void j() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921399, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void k() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_TAB_LIVE_INFO);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaTabLiveResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void l() {
        UrlManager.getInstance().addListener(new e());
    }

    public static void m() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_RECOMMEND_TAB);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaSpecialRecommendResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void n() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GAME_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(SdkLiveInfoListResponsedMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void o() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_NEW_SQUARE_SUB_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaNewSquareSubListResponseMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
