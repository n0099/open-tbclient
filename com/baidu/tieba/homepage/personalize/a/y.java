package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ap;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class y extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afE;
    private String aht;
    private boolean akj;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fAU = null;
        this.akj = true;
        this.afE = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.ciJ().lm(true);
                com.baidu.tieba.a.d.bEz().dF("page_recommend", "show_");
                if (view != null && lVar != null && lVar.bfG() != null && !StringUtils.isNull(lVar.bfG().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(lVar.Is("c12642"));
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cji());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(lVar.cjm());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjm());
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
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c10760");
                        aqVar.aj("obj_locate", 4);
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c10760");
                        aqVar2.aj("obj_locate", 2);
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c10760");
                        aqVar3.aj("obj_locate", 1);
                        TiebaStatic.log(aqVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar4 = new aq("c10760");
                            aqVar4.aj("obj_locate", 3);
                            TiebaStatic.log(aqVar4);
                        }
                        TiebaStatic.log(lVar.cjl());
                        com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjl());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(lVar.eji, y.this.fey, lVar.ciV(), i);
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
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.y.2
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
        com.baidu.card.aq aqVar = new com.baidu.card.aq(this.mPageContext.getPageActivity());
        aVar.c(aqVar);
        aqVar.bD(2);
        aVar.a((com.baidu.card.i) new ap(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akj);
        nVar.setForm("index");
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
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.y.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (y.this.afE != null) {
                        y.this.afE.a(amVar2.getView(), lVar);
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
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.eji == null) {
            return null;
        }
        lVar.wD(lVar.position + 1);
        com.baidu.tieba.card.s.ciJ().e(lVar.Ir("c12641"));
        com.baidu.tieba.a.d.bEz().a("page_recommend", "show_", lVar.cjh());
        amVar.tW().setPage(this.aht);
        amVar.aL(true).a(this.fAU);
        amVar.a(lVar.bfS(), this.jch);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afE);
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
