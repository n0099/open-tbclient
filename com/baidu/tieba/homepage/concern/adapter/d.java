package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, am<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.e> agG;
    private String aiw;
    private com.baidu.adp.widget.ListView.v amH;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.e eVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, eVar, 2);
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            com.baidu.tieba.homepage.concern.c.a(view, eVar, 1);
        } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
            com.baidu.tieba.homepage.concern.c.a(view, eVar, 3);
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.homepage.concern.adapter.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                com.baidu.tieba.card.t.csh().mj(true);
                com.baidu.tieba.a.d.bLU().dS("page_recommend", "show_");
                if (view != null && eVar != null && eVar.bmn() != null && !StringUtils.isNull(eVar.bmn().getTid())) {
                    d.this.a(view, eVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.e> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fzO);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 1;
        dVar.eEP = 1;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(9);
        anVar.setShareReportFrom(4);
        anVar.setFromForPb(1);
        aVar.b(anVar);
        aVar.tY().bz(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.e> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.d.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                d.this.a(view, qVar);
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, am<com.baidu.tieba.card.data.e> amVar) {
        if (eVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        eVar.ym(eVar.position + 1);
        amVar.tZ().setPosition(i);
        amVar.tZ().setPage(this.aiw);
        amVar.a(true, Align.ALIGN_RIGHT_TOP);
        amVar.uc();
        amVar.b((am<com.baidu.tieba.card.data.e>) eVar);
        com.baidu.tieba.card.t.csh().e(eVar.Jv("c12351"));
        amVar.tZ().a(this.agG);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof am)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) qVar;
            eVar.objType = 1;
            az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 1, false);
            ((am) view.getTag()).tZ().b(new a.C0097a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }
}
