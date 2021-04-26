package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.forumtest.ForumTestActivity;
import com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity;
import com.baidu.tieba.enterForum.model.EnterForumAdModel;
import com.baidu.tieba.enterForum.model.EnterForumAdResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpTestCloseMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketTestCloseMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.compatible.menukey.MenuKeyUtils;
import d.a.c.e.g.d;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EnterForumDelegateStatic extends d.a.i0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.c.e.g.c f15184a;

    /* renamed from: b  reason: collision with root package name */
    public static EnterForumModel f15185b;

    /* renamed from: c  reason: collision with root package name */
    public static EnterForumAdModel f15186c;

    /* loaded from: classes4.dex */
    public static class a implements EnterForumModel.f {
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            d.a.j0.i0.d.g e2 = eVar.f15283d.e();
            ArrayList arrayList = new ArrayList();
            Iterator<d.a.j0.i0.d.f> it = e2.b().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().G());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(2001329, arrayList));
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.a.c.a.e {
        @Override // d.a.c.a.e
        public void c(Object obj) {
            boolean z = obj instanceof d.a.j0.i0.d.b;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof forumRecommendSocketResponseMessage;
            if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && EnterForumDelegateStatic.f15185b.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (z) {
                    EnterForumDelegateStatic.f15185b.J((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    EnterForumDelegateStatic.f15185b.I((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
                if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                    EnterForumDelegateStatic.f15185b.C(true);
                } else {
                    EnterForumDelegateStatic.f15185b.D(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.j0.b0.c> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<>(2016562, new d.a.j0.i0.h.d());
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("unidispatch/hotuserrank")) {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(tbPageContext.getPageActivity());
                    hotUserRankActivityConfig.setUri(Uri.parse(lowerCase));
                    tbPageContext.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    return 0;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
            String data = customMessage.getData();
            VisitedForumData visitedForumData = new VisitedForumData();
            visitedForumData.setForumId(data);
            d.a.j0.i0.g.a.l().i(visitedForumData);
            TiebaStatic.log(new StatisticItem("c13005").param("fid", data));
            return null;
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
            d.a.i0.e0.c fragmentTabStructure;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                EnterForumDelegateStatic.f15186c.y();
            }
            ((d.a.i0.e0.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
            if (((d.a.i0.e0.d) customResponsedMessage.getData()).b() == null || (fragmentTabStructure = enterForumDelegateStatic.getFragmentTabStructure()) == null || fragmentTabStructure.f48462a.isAdded()) {
                return;
            }
            fragmentTabStructure.f48462a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f15187e;

            public a(i iVar, CustomResponsedMessage customResponsedMessage) {
                this.f15187e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                EnterForumDelegateStatic.f((Activity) this.f15187e.getData());
            }
        }

        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.isLogin()) {
                d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
                if (j.g("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    return;
                }
                d.a.i0.r.d0.b j2 = d.a.i0.r.d0.b.j();
                if (j2.k("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                    d.a.c.e.m.e.a().post(new a(this, customResponsedMessage));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements CustomMessageTask.CustomRunnable<Void> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            d.a.j0.i0.g.a.l().n();
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
            return new CustomResponsedMessage<>(2921483, d.a.j0.i0.g.a.l().k());
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends f0<Boolean> {
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.i0.z0.f0
        public Boolean doInBackground() {
            NetWork netWork = new NetWork();
            netWork.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
            netWork.addPostData("uid", TbadkCoreApplication.getCurrentAccount());
            String postNetData = netWork.postNetData();
            if (netWork.isNetSuccess() && netWork.getServerErrorCode() == 0) {
                try {
                    return Boolean.valueOf(new JSONObject(postNetData).optInt("live_bar_concerned", 0) == 1);
                } catch (JSONException unused) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements d.a.i0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f15188a;

        public m(Activity activity) {
            this.f15188a = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool.booleanValue()) {
                EnterForumDelegateStatic.s(this.f15188a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (EnterForumDelegateStatic.f15184a != null) {
                EnterForumDelegateStatic.f15184a.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class o implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f15189a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f15190b;

        public o(Handler handler, Runnable runnable) {
            this.f15189a = handler;
            this.f15190b = runnable;
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
            j.t("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), true);
            d.a.c.e.g.c unused = EnterForumDelegateStatic.f15184a = null;
            this.f15189a.removeCallbacks(this.f15190b);
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes4.dex */
    public static class p implements d.a.c.e.g.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f15191a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a(p pVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumDelegateStatic.f15184a.d();
            }
        }

        public p(Activity activity) {
            this.f15191a = activity;
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 4;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 16;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(this.f15191a, R.layout.enter_forum_ufan_tip, null);
            TextView textView = (TextView) bubbleLayout.findViewById(R.id.enter_forum_ufan_guide_tv);
            textView.setOnClickListener(new a(this));
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            bubbleLayout.f(SkinManager.getColor(R.color.cp_link_tip_a_alpha95));
            return bubbleLayout;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            if (d.a.c.e.p.l.h(this.f15191a) > 0.0f) {
                return (int) ((this.f15191a.getResources().getDimensionPixelSize(R.dimen.ds52) * 2) / d.a.c.e.p.l.h(this.f15191a));
            }
            return this.f15191a.getResources().getDimensionPixelSize(R.dimen.ds52);
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            int dimensionPixelSize = this.f15191a.getResources().getDimensionPixelSize(R.dimen.ds46) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            if (UtilHelper.getVirtualBarHeight(this.f15191a) > 0 || MenuKeyUtils.hasSmartBar()) {
                dimensionPixelSize -= d.a.c.e.p.l.g(this.f15191a, R.dimen.ds20);
            }
            return d.a.c.e.p.l.h(this.f15191a) > 0.0f ? (int) ((dimensionPixelSize * 3) / d.a.c.e.p.l.h(this.f15191a)) : dimensionPixelSize;
        }
    }

    static {
        h hVar = new h(2007002);
        hVar.setPriority(3);
        MessageManager.getInstance().registerListener(hVar);
        if (d.a.c.e.p.l.C()) {
            MessageManager.getInstance().registerListener(new i(2921341));
        }
        TbadkCoreApplication.getInst().RegisterIntent(ForumTestActivityConfig.class, ForumTestActivity.class);
        k();
        g();
        q();
        r();
        j();
        m();
        TbadkCoreApplication.getInst().RegisterIntent(HotUserRankActivityConfig.class, HotUserRankActivity.class);
        l();
        h();
        o();
        n();
        p();
        i();
    }

    public static void f(Activity activity) {
        d.a.i0.r.d0.b j2 = d.a.i0.r.d0.b.j();
        int k2 = j2.k("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0);
        d.a.i0.r.d0.b j3 = d.a.i0.r.d0.b.j();
        j3.k("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), k2 + 1);
        h0.b(new l(), new m(activity));
    }

    public static void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016562, new e());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void h() {
        UrlManager.getInstance().addListener(new f());
    }

    public static void i() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921519, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        d.a.j0.i0.g.a.l();
    }

    public static void j() {
        d.a.j0.d3.d0.a.e(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST, TbConfig.URL_ENTER_FORUM_AD, EnterForumAdResponsedMessage.class, false, false, true, false);
    }

    public static void k() {
        d.a.j0.d3.j0.c.d();
        if (f15185b == null) {
            EnterForumModel enterForumModel = new EnterForumModel(null);
            f15185b = enterForumModel;
            enterForumModel.P(new a());
        }
        if (f15186c == null) {
            EnterForumAdModel enterForumAdModel = new EnterForumAdModel();
            f15186c = enterForumAdModel;
            enterForumAdModel.setLoadDataCallBack(new b());
        }
        MessageManager.getInstance().registerListener(new c(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011));
        MessageManager.getInstance().registerListener(new d(2001323));
    }

    public static void l() {
        d.a.j0.d3.d0.a.h(309651, TabFeedListSocketResponsedMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309651, CmdConfigHttp.CMD_TAB_FEED_LIST, TbConfig.URL_TAB_FEED_LIST, TabFeedListHttpResponsedMessage.class, false, false, true, false);
    }

    public static void m() {
        d.a.j0.d3.d0.a.h(303011, forumRecommendSocketResponseMessage.class, false, false);
        d.a.j0.d3.d0.a.c(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    public static void n() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921483, new k());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        d.a.j0.i0.g.a.l();
    }

    public static void o() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921479, new j());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void p() {
        d.a.j0.d3.d0.a.h(309601, RecentlyVisitedForumSocketResponseMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309601, CmdConfigHttp.CMD_GET_HISTORY_FORUM, "c/f/forum/gethistoryforum", RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
        d.a.j0.d3.d0.a.e(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM, "c/c/forum/delHistoryForum", null, false, false, false, false);
    }

    public static void q() {
        d.a.j0.d3.d0.a.h(309630, ResponseSocketRecommendMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309630, CmdConfigHttp.CMD_RECOMMEND_FORUM, TbConfig.URL_ENTER_RECOMMEND_FORUM, ResponseHttpRecommendMessage.class, false, false, true, false);
    }

    public static void r() {
        d.a.j0.d3.d0.a.h(309633, ResponseSocketTestCloseMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309633, CmdConfigHttp.CMD_RECOMMEND_TEST_CLOSE, TbConfig.URL_RECOMMEND_FORUM_TEST_CLOSE, ResponseHttpTestCloseMessage.class, false, false, true, false);
    }

    public static void s(Activity activity) {
        d.a.c.e.g.c cVar = f15184a;
        if (cVar != null) {
            cVar.d();
        }
        Handler handler = new Handler();
        n nVar = new n();
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.g(new o(handler, nVar));
        dVar.j(activity.getWindow().getDecorView());
        dVar.c(20);
        dVar.i(false);
        dVar.a(new p(activity));
        d.a.c.e.g.c b2 = dVar.b();
        f15184a = b2;
        b2.m(activity);
        handler.postDelayed(nVar, 5000L);
    }

    @Override // d.a.i0.e0.b
    public d.a.i0.e0.c createFragmentTabStructure() {
        d.a.i0.e0.c cVar = new d.a.i0.e0.c();
        cVar.f48462a = new EnterForumTabFragment();
        cVar.f48466e = 1;
        cVar.f48463b = R.string.enter_forum;
        cVar.f48470i = d.a.i0.e0.c.l;
        cVar.f48467f = R.raw.lottie_tab_forum;
        cVar.f48469h = d.a.i0.e0.e.c.d().c("enterForum");
        return cVar;
    }

    @Override // d.a.i0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.mIndicator = maintabBottomIndicator;
        return maintabBottomIndicator;
    }

    @Override // d.a.i0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }
}
