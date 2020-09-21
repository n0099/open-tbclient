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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class w extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afn;
    private String ahc;
    private com.baidu.adp.widget.ListView.v alj;
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.foG = null;
        this.afn = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cfn().kO(true);
                com.baidu.tieba.a.d.bBN().dA("page_recommend", "show_");
                if (view != null && lVar != null && lVar.bcY() != null && !StringUtils.isNull(lVar.bcY().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(lVar.HF("c12642"));
                        com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfM());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(lVar.cfQ());
                        com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfQ());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(lVar.cfO());
                        com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfO());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(lVar.cfO());
                        com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfO());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(lVar.cfN());
                        com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfN());
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c10760");
                        aqVar.ai("obj_locate", 4);
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c10760");
                        aqVar2.ai("obj_locate", 2);
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c10760");
                        aqVar3.ai("obj_locate", 1);
                        TiebaStatic.log(aqVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar4 = new aq("c10760");
                            aqVar4.ai("obj_locate", 3);
                            TiebaStatic.log(aqVar4);
                        }
                        TiebaStatic.log(lVar.cfP());
                        com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfP());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dXg, w.this.eSq, lVar.cfz(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        czJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eSq);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.w.2
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        afVar.setFrom("index");
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        afVar2.setFrom("index");
        afVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        aVar.a((com.baidu.card.i) afVar2);
        afVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.w.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null) {
                    ay.a(absThreadDataSupport.bcY().efS, w.this.mContext, 2);
                }
            }
        });
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.w.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null) {
                    ay.a(absThreadDataSupport.bcY().efS, w.this.mContext, 2);
                    if (absThreadDataSupport.bcY().efS.ebt) {
                    }
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 1;
        cVar.dZe = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak a = aVar.a(true, viewGroup, this.alj);
        a.setSourceForPb(2);
        am<com.baidu.tieba.card.data.l> amVar = new am<>(a);
        amVar.setPageId(this.eSq);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.w.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (w.this.afn != null) {
                        w.this.afn.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.dXg == null) {
            return null;
        }
        lVar.vX(lVar.position + 1);
        amVar.tW().setPosition(i);
        com.baidu.tieba.card.s.cfn().e(lVar.HE("c12641"));
        com.baidu.tieba.a.d.bBN().a("page_recommend", "show_", lVar.cfL());
        amVar.tW().setPage(this.ahc);
        amVar.aL(true).a(this.foG);
        amVar.a(lVar.bdj(), this.iNp);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dXg, this.eSq, lVar.cfz());
        return amVar.getView();
    }

    private void czJ() {
        com.baidu.tieba.card.data.l.htQ = "c10705";
        com.baidu.tieba.card.data.l.htR = "c10730";
        com.baidu.tieba.card.data.l.htS = "c10731";
        com.baidu.tieba.card.data.l.htT = "c10704";
        com.baidu.tieba.card.data.l.htU = "c10755";
        com.baidu.tieba.card.data.l.htV = "c10710";
        com.baidu.tieba.card.data.l.htW = "c10736";
        com.baidu.tieba.card.data.l.htX = "c10737";
        com.baidu.tieba.card.data.l.htY = "c10711";
        com.baidu.tieba.card.data.l.htZ = "c10758";
        com.baidu.tieba.card.data.l.hua = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.foG = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alj = vVar;
    }
}
