package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Xr;
    private boolean ZQ;
    private NEGFeedBackView.a cIV;
    public BdUniqueId cnZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ZQ = true;
        this.cIV = null;
        this.Xr = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.threadData != null && kVar.threadData.ZA() != null) {
                    n.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.aQZ());
                    TiebaStatic.log(kVar.aRa());
                    n.this.d(kVar.threadData, kVar.aQN());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bmI();
    }

    private void bmI() {
        com.baidu.tieba.card.data.k.elb = "c13388";
        com.baidu.tieba.card.data.k.elc = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cnZ);
        dVar.aD(false);
        dVar.aE(false);
        dVar.aF(false);
        dVar.bu(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.n.1
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == d.g.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == d.g.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        com.baidu.card.p pVar = new com.baidu.card.p(this.mPageContext.getPageActivity());
        pVar.setFrom("index");
        pVar.setFromCDN(this.ZQ);
        aVar.b(pVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        z<com.baidu.tieba.card.data.k> zVar = new z<>(aVar.rw());
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        zVar.setPageId(this.cnZ);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.n.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.threadData != null && kVar.threadData.ZA() != null) {
                    n.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.aQZ());
                    TiebaStatic.log(kVar.aRa());
                    n.this.d(kVar.threadData, kVar.aQN());
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.threadData == null) {
            return null;
        }
        kVar.oo(kVar.position + 1);
        zVar.ry().a(this.cIV);
        zVar.a(kVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.Xr);
        com.baidu.tieba.card.t.aQD().b(kVar.aQY());
        com.baidu.tieba.a.d.awh().a("page_recommend", "show_", kVar.aQY());
        e(kVar.threadData, kVar.aQN());
        return zVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIV = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bg bgVar, View view) {
        if (bgVar != null && bgVar.ZA() != null) {
            String str = bgVar.ZA().id;
            String str2 = bgVar.ZA().link;
            String str3 = bgVar.ZA().h5_url;
            long parseLong = Long.parseLong(bgVar.getTid());
            String str4 = bgVar.ZA().name;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.H(str, str2, "1191008600000000")) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.ar(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.tz(bgVar.getTid());
                TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, "").bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", str4).bJ(VideoPlayActivityConfig.OBJ_ID, str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "index_card"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bg bgVar, int i) {
        if (bgVar != null && bgVar.ZA() != null) {
            com.baidu.tieba.q.c.cdp().b(this.cnZ, com.baidu.tieba.q.a.a(bgVar, "a002", "common_click", 1, i, bgVar.ZA().id));
        }
    }

    private void e(bg bgVar, int i) {
        if (bgVar != null && bgVar.ZA() != null) {
            String str = bgVar.ZA().id;
            com.baidu.tieba.q.c.cdp().a(this.cnZ, str, com.baidu.tieba.q.a.a(bgVar, "a002", "common_exp", i, str));
        }
    }
}
