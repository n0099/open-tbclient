package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class x extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> afK;
    private String ahw;
    private com.baidu.adp.widget.ListView.v alH;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fOM = null;
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.cnT().lO(true);
                com.baidu.tieba.a.d.bIl().dL("page_recommend", "show_");
                if (view != null && kVar != null && kVar.bjd() != null && !StringUtils.isNull(kVar.bjd().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.IJ("c12642"));
                        com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.com());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.cow());
                        com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cow());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.cou());
                        com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cou());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.cou());
                        com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cou());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.col());
                        com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.col());
                    } else if (id == R.id.god_reply_voice_btn) {
                        ar arVar = new ar("c10760");
                        arVar.ak("obj_locate", 4);
                        TiebaStatic.log(arVar);
                    } else if (id == R.id.god_reply_content) {
                        ar arVar2 = new ar("c10760");
                        arVar2.ak("obj_locate", 2);
                        TiebaStatic.log(arVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ar arVar3 = new ar("c10760");
                        arVar3.ak("obj_locate", 1);
                        TiebaStatic.log(arVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ar arVar4 = new ar("c10760");
                            arVar4.ak("obj_locate", 3);
                            TiebaStatic.log(arVar4);
                        }
                        TiebaStatic.log(kVar.cov());
                        com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cov());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.evQ, x.this.fsa, kVar.cof(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIA();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.k> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsa);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.2
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom("index");
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_H_X003));
        afVar2.setFrom("index");
        afVar2.e(com.baidu.tbadk.a.b.a.bhB(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.a.bhB(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        aVar.a((com.baidu.card.i) afVar2);
        afVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bjd() != null && aVar2.bjd().eEF != null) {
                    az.a(aVar2.bjd().eEF, x.this.mContext, 2);
                }
            }
        });
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bjd() != null && aVar2.bjd().eEF != null) {
                    az.a(aVar2.bjd().eEF, x.this.mContext, 2);
                    if (aVar2.bjd().eEF.eAf) {
                    }
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 1;
        dVar.exO = 1;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.alH);
        a2.setSourceForPb(2);
        am<com.baidu.tieba.card.data.k> amVar = new am<>(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.x.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (x.this.afK != null) {
                        x.this.afK.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.evQ == null) {
            return null;
        }
        kVar.xH(kVar.position + 1);
        amVar.tW().setPosition(i);
        com.baidu.tieba.card.t.cnT().e(kVar.II("c12641"));
        com.baidu.tieba.a.d.bIl().a("page_recommend", "show_", kVar.coo());
        amVar.tW().setPage(this.ahw);
        amVar.aN(true).a(this.fOM);
        amVar.a(kVar.bjn(), this.jvg);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.evQ, this.fsa, kVar.cof());
        return amVar.getView();
    }

    private void cIA() {
        com.baidu.tieba.card.data.k.ibX = "c10705";
        com.baidu.tieba.card.data.k.ibY = "c10730";
        com.baidu.tieba.card.data.k.ibZ = "c10731";
        com.baidu.tieba.card.data.k.ica = "c10704";
        com.baidu.tieba.card.data.k.icb = "c10755";
        com.baidu.tieba.card.data.k.icc = "c10710";
        com.baidu.tieba.card.data.k.icd = "c10736";
        com.baidu.tieba.card.data.k.ice = "c10737";
        com.baidu.tieba.card.data.k.icf = "c10711";
        com.baidu.tieba.card.data.k.icg = "c10758";
        com.baidu.tieba.card.data.k.ich = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }
}
