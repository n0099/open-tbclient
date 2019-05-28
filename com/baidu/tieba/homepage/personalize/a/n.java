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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Vj;
    private boolean XJ;
    private NEGFeedBackView.a cRg;
    public BdUniqueId cwh;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.XJ = true;
        this.cRg = null;
        this.Vj = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.threadData != null && kVar.threadData.aeh() != null) {
                    n.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.aYl());
                    TiebaStatic.log(kVar.aYm());
                    n.this.d(kVar.threadData, kVar.aXZ());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bun();
    }

    private void bun() {
        com.baidu.tieba.card.data.k.eAR = "c13388";
        com.baidu.tieba.card.data.k.eAS = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cwh);
        dVar.av(false);
        dVar.aw(false);
        dVar.ax(false);
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
        pVar.setFromCDN(this.XJ);
        aVar.b(pVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.u(this.mPageContext.getPageActivity()));
        z<com.baidu.tieba.card.data.k> zVar = new z<>(aVar.qr());
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        zVar.setPageId(this.cwh);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.n.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.threadData != null && kVar.threadData.aeh() != null) {
                    n.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.aYl());
                    TiebaStatic.log(kVar.aYm());
                    n.this.d(kVar.threadData, kVar.aXZ());
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
        kVar.ps(kVar.position + 1);
        zVar.qt().a(this.cRg);
        zVar.a(kVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.Vj);
        com.baidu.tieba.card.t.aXP().b(kVar.aYk());
        com.baidu.tieba.a.d.aBq().a("page_recommend", "show_", kVar.aYk());
        e(kVar.threadData, kVar.aXZ());
        return zVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cRg = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bg bgVar, View view) {
        if (bgVar != null && bgVar.aeh() != null) {
            String str = bgVar.aeh().id;
            String str2 = bgVar.aeh().link;
            String str3 = bgVar.aeh().h5_url;
            Long l = bgVar.aeh().swan_app_id;
            long parseLong = Long.parseLong(bgVar.getTid());
            long fid = bgVar.getFid();
            String str4 = bgVar.aeh().name;
            com.baidu.tbadk.core.sharedPref.b.agM().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.agM().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.agM().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bgVar.aeh().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.af(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.uS(bgVar.getTid());
                TiebaStatic.log(new am("c13274").l("fid", fid).l("tid", parseLong).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", str4).l(VideoPlayActivityConfig.OBJ_ID, l.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "index_card").P("obj_param1", bgVar.aeh().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bg bgVar, int i) {
        if (bgVar != null && bgVar.aeh() != null) {
            com.baidu.tieba.q.c.clv().b(this.cwh, com.baidu.tieba.q.a.a(bgVar, "a002", "common_click", 1, i, bgVar.aeh().id));
        }
    }

    private void e(bg bgVar, int i) {
        if (bgVar != null && bgVar.aeh() != null) {
            String str = bgVar.aeh().id;
            com.baidu.tieba.q.c.clv().a(this.cwh, str, com.baidu.tieba.q.a.a(bgVar, "a002", "common_exp", i, str));
        }
    }
}
