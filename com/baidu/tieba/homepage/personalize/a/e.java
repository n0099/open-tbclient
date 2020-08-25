package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.f, al<com.baidu.tieba.card.data.f>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.f> aeT;
    private String agH;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private NEGFeedBackView.a flJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.f fVar) {
        int i = 0;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(fVar.ccw());
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            i = 2;
        } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(fVar.dUS, this.ePv, fVar.ccj(), i);
        }
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.f>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.f fVar) {
                com.baidu.tieba.card.s.cbX().kK(true);
                com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
                if (view != null && fVar != null && fVar.bce() != null && !StringUtils.isNull(fVar.bce().getTid())) {
                    e.this.a(view, fVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.card.data.f> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePv);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 1;
        cVar.dWQ = 1;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        aVar.b(amVar);
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aj a = aVar.a(true, viewGroup, this.akI);
        a.setSourceForPb(2);
        al<com.baidu.tieba.card.data.f> alVar = new al<>(a);
        alVar.setPageId(this.ePv);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                e.this.a(view, qVar);
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, al<com.baidu.tieba.card.data.f> alVar) {
        if (fVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        fVar.vy(fVar.position + 1);
        alVar.tR().setPosition(i);
        alVar.tR().setPage(this.agH);
        alVar.aL(true).a(this.flJ);
        alVar.a(fVar.bcp(), this.iFO);
        alVar.b((al<com.baidu.tieba.card.data.f>) fVar);
        alVar.tR().a(this.aeT);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.cbX().e(fVar.ccv());
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.f) && (view.getTag() instanceof al)) {
            com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) qVar;
            fVar.objType = 1;
            ay.a((AbsThreadDataSupport) fVar, view.getContext(), 2, false);
            ((al) view.getTag()).tR().b(new a.C0095a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }
}
