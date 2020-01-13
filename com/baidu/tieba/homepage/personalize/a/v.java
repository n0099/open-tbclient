package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.ak;
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
/* loaded from: classes7.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JE;
    private String Lg;
    private com.baidu.adp.widget.ListView.r Oq;
    private NEGFeedBackView.a dQj;
    public BdUniqueId dxg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQj = null;
        this.JE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                if (view != null && kVar != null && kVar.axQ() != null && !StringUtils.isNull(kVar.axQ().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.zL("c12642"));
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btW());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bua());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.bua());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.btY());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btY());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.btY());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btY());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.btX());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btX());
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.Z("obj_locate", 4);
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.Z("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c10760");
                        anVar3.Z("obj_locate", 1);
                        TiebaStatic.log(anVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar4 = new an("c10760");
                            anVar4.Z("obj_locate", 3);
                            TiebaStatic.log(anVar4);
                        }
                        TiebaStatic.log(kVar.btZ());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btZ());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cNb, v.this.dxg, kVar.btK(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bNs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
        eVar.aI(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.v.2
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
        zVar2.setFrom("index");
        zVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        zVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.v.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.axQ() != null && aVar2.axQ().cPN != null) {
                    au.a(aVar2.axQ().cPN, v.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.h) zVar2);
        ak akVar = new ak(this.mPageContext.getPageActivity());
        akVar.b((Boolean) true);
        akVar.setFrom("index");
        akVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.v.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.axQ() != null && aVar2.axQ().cPN != null) {
                    au.a(aVar2.axQ().cPN, v.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.h) akVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 1;
        dVar.cJD = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aV(2);
        aVar.b(agVar);
        aVar.mS().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad a = aVar.a(true, viewGroup, this.Oq);
        a.aM(2);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(a);
        afVar.setPageId(this.dxg);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.v.5
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (v.this.JE != null) {
                        v.this.JE.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cNb == null) {
            return null;
        }
        kVar.rm(kVar.position + 1);
        afVar.mU().setPosition(i);
        com.baidu.tieba.card.r.btA().c(kVar.zK("c12641"));
        com.baidu.tieba.a.d.aVo().a("page_recommend", "show_", kVar.btV());
        afVar.mU().setPage(this.Lg);
        afVar.ad(true).a(this.dQj);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.JE);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cNb, this.dxg, kVar.btK());
        return afVar.getView();
    }

    private void bNs() {
        com.baidu.tieba.card.data.k.fKg = "c10705";
        com.baidu.tieba.card.data.k.fKh = "c10730";
        com.baidu.tieba.card.data.k.fKi = "c10731";
        com.baidu.tieba.card.data.k.fKj = "c10704";
        com.baidu.tieba.card.data.k.fKk = "c10755";
        com.baidu.tieba.card.data.k.fKl = "c10710";
        com.baidu.tieba.card.data.k.fKm = "c10736";
        com.baidu.tieba.card.data.k.fKn = "c10737";
        com.baidu.tieba.card.data.k.fKo = "c10711";
        com.baidu.tieba.card.data.k.fKp = "c10758";
        com.baidu.tieba.card.data.k.fKq = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQj = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }
}
