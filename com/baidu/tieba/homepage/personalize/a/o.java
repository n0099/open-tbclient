package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class o extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> aeV;
    private String agJ;
    private boolean ajt;
    public BdUniqueId ePz;
    private NEGFeedBackView.a flN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.flN = null;
        this.ajt = true;
        this.aeV = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                int i = 1;
                com.baidu.tieba.card.s.cbY().kM(true);
                com.baidu.tieba.a.d.bAB().dA("page_recommend", "show_");
                if (lVar != null && lVar.bce() != null && !at.isEmpty(lVar.bce().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(lVar.ccx());
                        com.baidu.tieba.a.d.bAB().a("page_recommend", "clk_", lVar.ccx());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(lVar.ccx());
                        com.baidu.tieba.a.d.bAB().a("page_recommend", "clk_", lVar.ccx());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(lVar.ccB());
                        com.baidu.tieba.a.d.bAB().a("page_recommend", "clk_", lVar.ccB());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(lVar.ccz());
                        com.baidu.tieba.a.d.bAB().a("page_recommend", "clk_", lVar.ccz());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(lVar.ccz());
                        com.baidu.tieba.a.d.bAB().a("page_recommend", "clk_", lVar.ccz());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(lVar.ccy());
                        com.baidu.tieba.a.d.bAB().a("page_recommend", "clk_", lVar.ccy());
                        i = 0;
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c10760");
                        aqVar.ai("obj_locate", 4);
                        TiebaStatic.log(aqVar);
                        i = 0;
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c10760");
                        aqVar2.ai("obj_locate", 2);
                        TiebaStatic.log(aqVar2);
                        i = 0;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                aq aqVar3 = new aq("c10760");
                                aqVar3.ai("obj_locate", 3);
                                TiebaStatic.log(aqVar3);
                            }
                            TiebaStatic.log(lVar.ccA());
                            com.baidu.tieba.a.d.bAB().a("page_recommend", "clk_", lVar.ccA());
                        }
                        i = 0;
                    } else {
                        aq aqVar4 = new aq("c10760");
                        aqVar4.ai("obj_locate", 1);
                        TiebaStatic.log(aqVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUW, o.this.ePz, lVar.cck(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cyl();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePz);
        eVar.bl(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.o.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        aVar.c(new com.baidu.card.s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajt);
        mVar.setForm("index");
        mVar.a(new aq("c13342"));
        aVar.a((com.baidu.card.h) mVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWO = 1;
        cVar.dWU = 1;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        aVar.b(amVar);
        aj tQ = aVar.tQ();
        tQ.setSourceForPb(2);
        al<com.baidu.tieba.card.data.l> alVar = new al<>(tQ);
        alVar.setPageId(this.ePz);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.o.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (o.this.aeV != null) {
                        o.this.aeV.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        if (lVar == null || alVar == null || alVar.tR() == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        com.baidu.tieba.card.s.cbY().e(lVar.Hg("c12190"));
        if (alVar.tR() instanceof com.baidu.tieba.a.e) {
            alVar.tR().setPage(this.agJ);
        }
        com.baidu.card.aa aL = alVar.aL(true);
        aL.a(this.flN);
        alVar.a(lVar.bcp(), this.iFU);
        aL.F(lVar.bcg());
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.b(this.aeV);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUW, this.ePz, lVar.cck());
        return alVar.getView();
    }

    private void cyl() {
        com.baidu.tieba.card.data.l.hmN = "c10705";
        com.baidu.tieba.card.data.l.hmO = "c10730";
        com.baidu.tieba.card.data.l.hmP = "c10731";
        com.baidu.tieba.card.data.l.hmQ = "c10704";
        com.baidu.tieba.card.data.l.hmR = "c10755";
        com.baidu.tieba.card.data.l.hmS = "c10710";
        com.baidu.tieba.card.data.l.hmT = "c10736";
        com.baidu.tieba.card.data.l.hmU = "c10737";
        com.baidu.tieba.card.data.l.hmV = "c10711";
        com.baidu.tieba.card.data.l.hmW = "c10758";
        com.baidu.tieba.card.data.l.hmX = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flN = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
        this.agJ = str;
    }

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }
}
