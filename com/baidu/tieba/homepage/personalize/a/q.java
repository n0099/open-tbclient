package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Vj;
    private String Wt;
    private boolean XJ;
    private NEGFeedBackView.a cRf;
    public BdUniqueId cwh;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRf = null;
        this.XJ = true;
        this.Vj = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aXM().gM(true);
                com.baidu.tieba.a.d.aBn().bJ("page_recommend", "show_");
                if (view != null && kVar != null && kVar.abv() != null && !StringUtils.isNull(kVar.abv().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.vc("c12642"));
                        com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYi());
                        com.baidu.tieba.q.c.clt().b(q.this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aXW(), false, (String) null, (String) null));
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.aYm());
                        com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYm());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.aYk());
                        com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYk());
                        com.baidu.tieba.q.c.clt().b(q.this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aXW(), false, (String) null, (String) null));
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.aYk());
                        com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYk());
                        com.baidu.tieba.q.c.clt().b(q.this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aXW(), false, (String) null, (String) null));
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.aYj());
                        com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYj());
                    } else if (id == R.id.god_reply_voice_btn) {
                        am amVar = new am("c10760");
                        amVar.P("obj_locate", 4);
                        TiebaStatic.log(amVar);
                    } else if (id == R.id.god_reply_content) {
                        am amVar2 = new am("c10760");
                        amVar2.P("obj_locate", 2);
                        TiebaStatic.log(amVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        am amVar3 = new am("c10760");
                        amVar3.P("obj_locate", 1);
                        TiebaStatic.log(amVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            am amVar4 = new am("c10760");
                            amVar4.P("obj_locate", 3);
                            TiebaStatic.log(amVar4);
                        }
                        TiebaStatic.log(kVar.aYl());
                        com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYl());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        buk();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cwh);
        dVar.bn(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.q.2
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
        com.baidu.card.ab abVar = new com.baidu.card.ab(this.mPageContext.getPageActivity());
        aVar.b(abVar);
        abVar.bx(2);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XJ);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEy = 1;
        dVar2.bED = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        x qr = aVar.qr();
        qr.bq(2);
        z<com.baidu.tieba.card.data.k> zVar = new z<>(qr);
        zVar.setPageId(this.cwh);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.q.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (q.this.Vj != null) {
                        q.this.Vj.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.qs().b(new a.C0038a(1));
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
        com.baidu.tieba.card.t.aXM().b(kVar.vb("c12641"));
        com.baidu.tieba.a.d.aBn().a("page_recommend", "show_", kVar.aYh());
        zVar.qs().setPage(this.Wt);
        zVar.qt().a(this.cRf);
        zVar.a(kVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.Vj);
        com.baidu.tieba.q.c.clt().a(this.cwh, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aXW(), false, null, null));
        return zVar.getView();
    }

    private void buk() {
        com.baidu.tieba.card.data.k.eAF = "c10705";
        com.baidu.tieba.card.data.k.eAG = "c10730";
        com.baidu.tieba.card.data.k.eAH = "c10731";
        com.baidu.tieba.card.data.k.eAI = "c10704";
        com.baidu.tieba.card.data.k.eAJ = "c10755";
        com.baidu.tieba.card.data.k.eAK = "c10710";
        com.baidu.tieba.card.data.k.eAL = "c10736";
        com.baidu.tieba.card.data.k.eAM = "c10737";
        com.baidu.tieba.card.data.k.eAN = "c10711";
        com.baidu.tieba.card.data.k.eAO = "c10758";
        com.baidu.tieba.card.data.k.eAP = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cRf = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }
}
