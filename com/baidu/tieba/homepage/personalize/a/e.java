package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.e, ag<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.e> adt;
    private String aeX;
    private com.baidu.adp.widget.ListView.t aib;
    private NEGFeedBackView.a eJK;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.e eVar) {
        int i = 0;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(eVar.bLO());
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            i = 2;
        } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(eVar.dEA, this.epM, eVar.bLB(), i);
        }
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                com.baidu.tieba.card.s.bLs().jv(true);
                com.baidu.tieba.a.d.bmb().de("page_recommend", "show_");
                if (view != null && eVar != null && eVar.aOi() != null && !StringUtils.isNull(eVar.aOi().getTid())) {
                    e.this.a(view, eVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 1;
        cVar.dBf = 1;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(1);
        ahVar.setShareReportFrom(3);
        ahVar.bm(2);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        ae a = aVar.a(true, viewGroup, this.aib);
        a.setSourceForPb(2);
        ag<com.baidu.tieba.card.data.e> agVar = new ag<>(a);
        agVar.setPageId(this.epM);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                e.this.a(view, oVar);
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, ag<com.baidu.tieba.card.data.e> agVar) {
        if (eVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        eVar.st(eVar.position + 1);
        agVar.rM().setPosition(i);
        agVar.rM().setPage(this.aeX);
        agVar.aH(true).a(this.eJK);
        agVar.a(eVar.aOs(), this.hWZ);
        agVar.b((ag<com.baidu.tieba.card.data.e>) eVar);
        agVar.rM().a(this.adt);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.bLs().e(eVar.bLN());
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.o oVar) {
        if ((oVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ag)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) oVar;
            eVar.objType = 1;
            au.a((AbsThreadDataSupport) eVar, view.getContext(), 2, false);
            ((ag) view.getTag()).rM().b(new a.C0097a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.aib = tVar;
    }
}
