package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class y extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adN;
    private String afx;
    private boolean aib;
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.far = null;
        this.aib = true;
        this.adN = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                if (view != null && kVar != null && kVar.aTN() != null && !StringUtils.isNull(kVar.aTN().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.EI("c12642"));
                        com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSk());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bSo());
                        com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSo());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bSm());
                        com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSm());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bSm());
                        com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSm());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bSl());
                        com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSl());
                    } else if (id == R.id.god_reply_voice_btn) {
                        ap apVar = new ap("c10760");
                        apVar.ah("obj_locate", 4);
                        TiebaStatic.log(apVar);
                    } else if (id == R.id.god_reply_content) {
                        ap apVar2 = new ap("c10760");
                        apVar2.ah("obj_locate", 2);
                        TiebaStatic.log(apVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ap apVar3 = new ap("c10760");
                        apVar3.ah("obj_locate", 1);
                        TiebaStatic.log(apVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ap apVar4 = new ap("c10760");
                            apVar4.ah("obj_locate", 3);
                            TiebaStatic.log(apVar4);
                        }
                        TiebaStatic.log(kVar.bSn());
                        com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSn());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLK, y.this.eEU, kVar.bRX(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cnr();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.bg(1024);
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
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aVar.c(aoVar);
        aoVar.bu(2);
        aVar.a((com.baidu.card.h) new an(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aib);
        lVar.setForm("index");
        aVar.a((com.baidu.card.h) lVar);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 1;
        cVar.dNH = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(1);
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        aVar.b(alVar);
        ai sf = aVar.sf();
        sf.setSourceForPb(2);
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(sf);
        akVar.setPageId(this.eEU);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.y.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (y.this.adN != null) {
                        y.this.adN.a(akVar2.getView(), kVar);
                    }
                    ax.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLK == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        com.baidu.tieba.card.s.bRL().e(kVar.EH("c12641"));
        com.baidu.tieba.a.d.brD().a("page_recommend", "show_", kVar.bSj());
        akVar.sg().setPage(this.afx);
        akVar.aK(true).a(this.far);
        akVar.a(kVar.aTY(), this.irz);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLK, this.eEU, kVar.bRX());
        return akVar.getView();
    }

    private void cnr() {
        com.baidu.tieba.card.data.k.gZQ = "c10705";
        com.baidu.tieba.card.data.k.gZR = "c10730";
        com.baidu.tieba.card.data.k.gZS = "c10731";
        com.baidu.tieba.card.data.k.gZT = "c10704";
        com.baidu.tieba.card.data.k.gZU = "c10755";
        com.baidu.tieba.card.data.k.gZV = "c10710";
        com.baidu.tieba.card.data.k.gZW = "c10736";
        com.baidu.tieba.card.data.k.gZX = "c10737";
        com.baidu.tieba.card.data.k.gZY = "c10711";
        com.baidu.tieba.card.data.k.gZZ = "c10758";
        com.baidu.tieba.card.data.k.haa = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.far = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }
}
