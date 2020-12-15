package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private com.baidu.adp.widget.ListView.v amH;
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csh().mj(true);
                if (view != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    l.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNQ();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i;
        ar csA;
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(kVar.csz());
                com.baidu.tieba.a.d.bLU().a("page_concern", "clk_", kVar.csz());
                i = 9;
            } else {
                if (kVar.bnv()) {
                    csA = kVar.csB();
                } else {
                    csA = kVar.csA();
                }
                TiebaStatic.log(csA);
                com.baidu.tieba.a.d.bLU().a("page_concern", "clk_", csA);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.cst(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        aVar.a(new com.baidu.card.m(this.mPageContext.getPageActivity()));
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.amH);
        a2.setSourceForPb(1);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.l.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (l.this.agG != null) {
                        l.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPosition(i);
        amVar.tZ().setPage(this.aiw);
        amVar.a(false, Align.ALIGN_RIGHT_TOP, this.fWC);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.card.t.csh().e(kVar.csC());
        com.baidu.tieba.a.d.bLU().e(kVar.csC());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.cst());
        return amVar.getView();
    }

    private void cNQ() {
        com.baidu.tieba.card.data.k.imW = "c10705";
        com.baidu.tieba.card.data.k.imX = "c10730";
        com.baidu.tieba.card.data.k.imY = "c10731";
        com.baidu.tieba.card.data.k.imZ = "c10704";
        com.baidu.tieba.card.data.k.ina = "c10755";
        com.baidu.tieba.card.data.k.inb = "c10710";
        com.baidu.tieba.card.data.k.inc = "c10736";
        com.baidu.tieba.card.data.k.ind = "c10737";
        com.baidu.tieba.card.data.k.ine = "c10711";
        com.baidu.tieba.card.data.k.inf = "c10758";
        com.baidu.tieba.card.data.k.ing = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
