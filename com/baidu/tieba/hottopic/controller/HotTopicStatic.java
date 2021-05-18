package com.baidu.tieba.hottopic.controller;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.frs.FrsHottopicFragment;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newlist.HotTopicListActivity;
import d.a.j0.r.q.a2;
import d.a.j0.z0.n0;
import d.a.k0.q0.g;
import java.util.Map;
/* loaded from: classes4.dex */
public class HotTopicStatic {

    /* loaded from: classes4.dex */
    public static class a implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            String lowerCase;
            if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null || (lowerCase = strArr[0].toLowerCase()) == null || d.a.j0.p0.b.c(tbPageContext, false, true) || !(lowerCase.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC) || lowerCase.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || lowerCase.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC) || lowerCase.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW))) {
                return 3;
            }
            String c2 = n0.c(lowerCase, "topic_id=");
            String c3 = n0.c(lowerCase, "topic_name=");
            if (!StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
                tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(c2, c3, (strArr == null || strArr.length <= 1 || StringUtils.isNull(strArr[1])) ? "" : strArr[1])));
                return 1;
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new d.a.k0.c1.d.c(null, a2.p3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements UrlManager.UrlSchemaHandler {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlSchemaHandler
        public void deal(TbPageContext<?> tbPageContext, Map<String, String> map) {
            if (tbPageContext == null || map == null) {
                return;
            }
            new HotRanklistActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(map.get(IntentConfig.CALL_FROM), map.get(IntentConfig.LIST_TYPE)).start();
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a extends d.a.j0.e0.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f16851a;

            public a(d dVar, g gVar) {
                this.f16851a = gVar;
            }

            @Override // d.a.j0.e0.b
            public d.a.j0.e0.c createFragmentTabStructure() {
                FrsHottopicFragment frsHottopicFragment = new FrsHottopicFragment();
                Bundle bundle = new Bundle();
                bundle.putString("fid", this.f16851a.b());
                bundle.putString("from", this.f16851a.d());
                frsHottopicFragment.setArguments(bundle);
                d.a.j0.e0.c cVar = new d.a.j0.e0.c();
                cVar.f49290a = frsHottopicFragment;
                cVar.f49294e = 401;
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

        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof g)) {
                return;
            }
            g gVar = (g) customResponsedMessage.getData();
            gVar.a(new a(this, gVar));
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(HotTopicActivityConfig.class, HotTopicDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(RelateTopicForumActivityConfig.class, RelateTopicForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(HotRanklistActivityConfig.class, HotTopicListActivity.class);
        f();
        h();
        c();
        b();
        a();
        e();
        g();
        d();
    }

    public static void a() {
        MessageManager.getInstance().registerListener(new b(2003008));
    }

    public static void b() {
        UrlManager.getInstance().addListener(new a());
    }

    public static void c() {
        d.a.k0.d3.d0.a.h(309085, BlessSocketResponseMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
    }

    public static void d() {
        d dVar = new d(2001623);
        dVar.setPriority(1);
        MessageManager.getInstance().registerListener(dVar);
    }

    public static void e() {
        d.a.k0.d3.d0.a.h(309289, ResponseSocketHotRanklistMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309289, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, TbConfig.URL_GET_HOT_RANKLIST_DATA, ResponseHttpHotRanklistMessage.class, false, false, true, false);
    }

    public static void f() {
        d.a.k0.d3.d0.a.h(303050, ResponseSocketHotTopicMessage.class, false, false);
        d.a.k0.d3.d0.a.c(303050, CmdConfigHttp.CMD_HOT_TOPIC, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
    }

    public static void g() {
        UrlManager.getInstance().registerSchema(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST, new c());
    }

    public static void h() {
        d.a.k0.d3.d0.a.h(309005, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309005, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
    }
}
