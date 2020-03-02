package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OR;
    public BdUniqueId dBk;
    private NEGFeedBackView.a dUq;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUq = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bvg().ib(true);
                com.baidu.tieba.a.d.aXF().cv("page_recommend", "show_");
                if (view != null && kVar != null && kVar.aAg() != null && !StringUtils.isNull(kVar.aAg().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.Ab("c12642"));
                        com.baidu.tieba.a.d.aXF().a("page_recommend", "clk_", kVar.bvC());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bvG());
                        com.baidu.tieba.a.d.aXF().a("page_recommend", "clk_", kVar.bvG());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bvE());
                        com.baidu.tieba.a.d.aXF().a("page_recommend", "clk_", kVar.bvE());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bvE());
                        com.baidu.tieba.a.d.aXF().a("page_recommend", "clk_", kVar.bvE());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bvD());
                        com.baidu.tieba.a.d.aXF().a("page_recommend", "clk_", kVar.bvD());
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.X("obj_locate", 4);
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.X("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c10760");
                        anVar3.X("obj_locate", 1);
                        TiebaStatic.log(anVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar4 = new an("c10760");
                            anVar4.X("obj_locate", 3);
                            TiebaStatic.log(anVar4);
                        }
                        TiebaStatic.log(kVar.bvF());
                        com.baidu.tieba.a.d.aXF().a("page_recommend", "clk_", kVar.bvF());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRf, s.this.dBk, kVar.bvq(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bOW();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBk);
        eVar.aL(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            @Override // com.baidu.card.e.a
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
        aVar.a(eVar);
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext);
        zVar.b((Boolean) false);
        zVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        zVar.setFrom("index");
        aVar.c(zVar);
        com.baidu.card.z zVar2 = new com.baidu.card.z(this.mPageContext);
        zVar2.b((Boolean) true);
        zVar2.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        zVar2.setFrom("index");
        zVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        aVar.a((com.baidu.card.h) zVar2);
        zVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.s.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aAg() != null && aVar2.aAg().cTQ != null) {
                    au.a(aVar2.aAg().cTQ, s.this.mContext, 2);
                }
            }
        });
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        ahVar.b((Boolean) true);
        ahVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.s.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aAg() != null && aVar2.aAg().cTQ != null) {
                    au.a(aVar2.aAg().cTQ, s.this.mContext, 2);
                    if (aVar2.aAg().cTQ.cPJ) {
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) ahVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 1;
        dVar.cNH = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        aVar.b(agVar);
        aVar.ni().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad a = aVar.a(true, viewGroup, this.OR);
        a.aQ(2);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(a);
        afVar.setPageId(this.dBk);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.s.5
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (s.this.JZ != null) {
                        s.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRf == null) {
            return null;
        }
        kVar.rt(kVar.position + 1);
        afVar.nk().setPosition(i);
        com.baidu.tieba.card.r.bvg().d(kVar.Aa("c12641"));
        com.baidu.tieba.a.d.aXF().a("page_recommend", "show_", kVar.bvB());
        afVar.nk().setPage(this.LC);
        afVar.ag(true).a(this.dUq);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRf, this.dBk, kVar.bvq());
        return afVar.getView();
    }

    private void bOW() {
        com.baidu.tieba.card.data.k.fME = "c10705";
        com.baidu.tieba.card.data.k.fMF = "c10730";
        com.baidu.tieba.card.data.k.fMG = "c10731";
        com.baidu.tieba.card.data.k.fMH = "c10704";
        com.baidu.tieba.card.data.k.fMI = "c10755";
        com.baidu.tieba.card.data.k.fMJ = "c10710";
        com.baidu.tieba.card.data.k.fMK = "c10736";
        com.baidu.tieba.card.data.k.fML = "c10737";
        com.baidu.tieba.card.data.k.fMM = "c10711";
        com.baidu.tieba.card.data.k.fMN = "c10758";
        com.baidu.tieba.card.data.k.fMO = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUq = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OR = rVar;
    }
}
