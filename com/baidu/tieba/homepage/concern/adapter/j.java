package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> afn;
    private String ahc;
    private com.baidu.adp.widget.ListView.v alj;
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afn = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cfn().kO(true);
                if (view != null && lVar != null && lVar.bcY() != null && !StringUtils.isNull(lVar.bcY().getTid())) {
                    j.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        czJ();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alj = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int i;
        aq cfM;
        int id = view.getId();
        if (lVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(lVar.cfN());
                com.baidu.tieba.a.d.bBN().a("page_concern", "clk_", lVar.cfN());
                i = 9;
            } else {
                if (lVar.bee()) {
                    cfM = lVar.cfR();
                } else {
                    cfM = lVar.cfM();
                }
                TiebaStatic.log(cfM);
                com.baidu.tieba.a.d.bBN().a("page_concern", "clk_", cfM);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.dXg, this.eSq, lVar.cfz(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        aVar.tU().by(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds30, R.dimen.tbds10)));
        aVar.a(new com.baidu.card.m(this.mPageContext.getPageActivity()));
        ak a = aVar.a(false, viewGroup, this.alj);
        a.setSourceForPb(1);
        am amVar = new am(a);
        amVar.setPageId(this.eSq);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.adapter.j.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (j.this.afn != null) {
                        j.this.afn.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
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
        amVar.tW().setPage(this.ahc);
        amVar.a(false, Align.ALIGN_RIGHT_TOP, this.foG);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        com.baidu.tieba.card.s.cfn().e(lVar.cfL());
        com.baidu.tieba.a.d.bBN().e(lVar.cfL());
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

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }
}
