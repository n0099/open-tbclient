package com.baidu.tieba.homepage.personalize.a;

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
/* loaded from: classes21.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> afK;
    private String ahw;
    private com.baidu.adp.widget.ListView.v alH;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.cnT().lO(true);
                if (view != null && kVar != null && kVar.bjd() != null && !StringUtils.isNull(kVar.bjd().getTid())) {
                    m.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIA();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i;
        ar com2;
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(kVar.col());
                com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.col());
                i = 9;
            } else {
                if (kVar.bki()) {
                    com2 = kVar.con();
                } else {
                    com2 = kVar.com();
                }
                TiebaStatic.log(com2);
                com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", com2);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(kVar.evQ, this.fsa, kVar.cof(), i);
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
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.alH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.m.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (m.this.afK != null) {
                        m.this.afK.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
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
        amVar.tW().setPage(this.ahw);
        amVar.a(true, Align.ALIGN_RIGHT_TOP, this.fOM);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        com.baidu.tieba.card.t.cnT().e(kVar.coo());
        com.baidu.tieba.a.d.bIl().e(kVar.coo());
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

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }
}
