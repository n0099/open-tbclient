package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
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
/* loaded from: classes22.dex */
public class o extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afE;
    private String aht;
    private boolean akj;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fAU = null;
        this.akj = true;
        this.afE = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                int i = 1;
                com.baidu.tieba.card.s.ciJ().lm(true);
                com.baidu.tieba.a.d.bEz().dF("page_recommend", "show_");
                if (lVar != null && lVar.bfG() != null && !at.isEmpty(lVar.bfG().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(lVar.cji());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cji());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(lVar.cji());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cji());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(lVar.cjm());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjm());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(lVar.cjk());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjk());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(lVar.cjk());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjk());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(lVar.cjj());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjj());
                        i = 0;
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c10760");
                        aqVar.aj("obj_locate", 4);
                        TiebaStatic.log(aqVar);
                        i = 0;
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c10760");
                        aqVar2.aj("obj_locate", 2);
                        TiebaStatic.log(aqVar2);
                        i = 0;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                aq aqVar3 = new aq("c10760");
                                aqVar3.aj("obj_locate", 3);
                                TiebaStatic.log(aqVar3);
                            }
                            TiebaStatic.log(lVar.cjl());
                            com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjl());
                        }
                        i = 0;
                    } else {
                        aq aqVar4 = new aq("c10760");
                        aqVar4.aj("obj_locate", 1);
                        TiebaStatic.log(aqVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(lVar.eji, o.this.fey, lVar.ciV(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cDn();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fey);
        eVar.bp(1024);
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
        aVar.c(new com.baidu.card.t(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akj);
        nVar.setForm("index");
        nVar.a(new aq("c13342"));
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 1;
        cVar.elg = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        aVar.b(anVar);
        ak tV = aVar.tV();
        tV.setSourceForPb(2);
        am<com.baidu.tieba.card.data.l> amVar = new am<>(tV);
        amVar.setPageId(this.fey);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.o.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (o.this.afE != null) {
                        o.this.afE.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.tW() == null) {
            return null;
        }
        lVar.wD(lVar.position + 1);
        com.baidu.tieba.card.s.ciJ().e(lVar.Iq("c12190"));
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.aht);
        }
        com.baidu.card.ab aL = amVar.aL(true);
        aL.a(this.fAU);
        amVar.a(lVar.bfS(), this.jch);
        aL.H(lVar.bfI());
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.b(this.afE);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.eji, this.fey, lVar.ciV());
        return amVar.getView();
    }

    private void cDn() {
        com.baidu.tieba.card.data.l.hIL = "c10705";
        com.baidu.tieba.card.data.l.hIM = "c10730";
        com.baidu.tieba.card.data.l.hIN = "c10731";
        com.baidu.tieba.card.data.l.hIO = "c10704";
        com.baidu.tieba.card.data.l.hIP = "c10755";
        com.baidu.tieba.card.data.l.hIQ = "c10710";
        com.baidu.tieba.card.data.l.hIR = "c10736";
        com.baidu.tieba.card.data.l.hIS = "c10737";
        com.baidu.tieba.card.data.l.hIT = "c10711";
        com.baidu.tieba.card.data.l.hIU = "c10758";
        com.baidu.tieba.card.data.l.hIV = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fAU = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }
}
