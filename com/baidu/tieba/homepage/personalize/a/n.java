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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VB;
    private boolean Yd;
    private NEGFeedBackView.a cTD;
    public BdUniqueId cyA;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Yd = true;
        this.cTD = null;
        this.VB = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.threadData != null && kVar.threadData.afo() != null) {
                    n.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.baQ());
                    TiebaStatic.log(kVar.baR());
                    n.this.d(kVar.threadData, kVar.baD());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bxU();
    }

    private void bxU() {
        com.baidu.tieba.card.data.k.eHD = "c13388";
        com.baidu.tieba.card.data.k.eHE = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cyA);
        dVar.ay(false);
        dVar.az(false);
        dVar.aA(false);
        dVar.bn(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.n.1
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
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
        pVar.setFromCDN(this.Yd);
        aVar.b(pVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.u(this.mPageContext.getPageActivity()));
        z<com.baidu.tieba.card.data.k> zVar = new z<>(aVar.qP());
        zVar.setPageId(this.cyA);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.n.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.threadData != null && kVar.threadData.afo() != null) {
                    n.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.baQ());
                    TiebaStatic.log(kVar.baR());
                    n.this.d(kVar.threadData, kVar.baD());
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
        kVar.pN(kVar.position + 1);
        zVar.qR().a(this.cTD);
        zVar.a(kVar);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.VB);
        com.baidu.tieba.card.t.bat().c(kVar.baP());
        com.baidu.tieba.a.d.aCV().a("page_recommend", "show_", kVar.baP());
        e(kVar.threadData, kVar.baD());
        return zVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cTD = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bh bhVar, View view) {
        if (bhVar != null && bhVar.afo() != null) {
            String str = bhVar.afo().id;
            String str2 = bhVar.afo().link;
            String str3 = bhVar.afo().h5_url;
            Long l = bhVar.afo().swan_app_id;
            long parseLong = Long.parseLong(bhVar.getTid());
            long fid = bhVar.getFid();
            String str4 = bhVar.afo().name;
            com.baidu.tbadk.core.sharedPref.b.ahU().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bhVar.afo().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.ae(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.vW(bhVar.getTid());
                TiebaStatic.log(new an("c13274").n("fid", fid).n("tid", parseLong).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", str4).n(VideoPlayActivityConfig.OBJ_ID, l.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "index_card").P("obj_param1", bhVar.afo().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bh bhVar, int i) {
        if (bhVar != null && bhVar.afo() != null) {
            com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(bhVar, "a002", "common_click", 1, i, bhVar.afo().id));
        }
    }

    private void e(bh bhVar, int i) {
        if (bhVar != null && bhVar.afo() != null) {
            String str = bhVar.afo().id;
            com.baidu.tieba.q.c.cpt().a(this.cyA, str, com.baidu.tieba.q.a.a(bhVar, "a002", "common_exp", i, str));
        }
    }
}
