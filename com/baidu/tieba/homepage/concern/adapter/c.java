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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, am<com.baidu.tieba.card.data.f>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.f> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    public BdUniqueId fsQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.f fVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, fVar, 2);
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            com.baidu.tieba.homepage.concern.c.a(view, fVar, 1);
        } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
            com.baidu.tieba.homepage.concern.c.a(view, fVar, 3);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<com.baidu.tieba.card.data.f>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.f fVar) {
                com.baidu.tieba.card.t.cor().lN(true);
                com.baidu.tieba.a.d.bIR().dM("page_recommend", "show_");
                if (view != null && fVar != null && fVar.bjZ() != null && !StringUtils.isNull(fVar.bjZ().getTid())) {
                    c.this.a(view, fVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<com.baidu.tieba.card.data.f> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsQ);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 1;
        cVar.ezz = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(9);
        anVar.setShareReportFrom(4);
        anVar.setFromForPb(1);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        ak a2 = aVar.a(true, viewGroup, this.alD);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.f> amVar = new am<>(a2);
        amVar.setPageId(this.fsQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                c.this.a(view, qVar);
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, am<com.baidu.tieba.card.data.f> amVar) {
        if (fVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        fVar.xj(fVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.ahu);
        amVar.a(true, Align.ALIGN_RIGHT_TOP);
        amVar.tZ();
        amVar.b((am<com.baidu.tieba.card.data.f>) fVar);
        com.baidu.tieba.card.t.cor().e(fVar.Jf("c12351"));
        amVar.tW().a(this.afF);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.f) && (view.getTag() instanceof am)) {
            com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) qVar;
            fVar.objType = 1;
            ay.a((AbsThreadDataSupport) fVar, view.getContext(), 1, false);
            ((am) view.getTag()).tW().b(new a.C0097a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }
}
