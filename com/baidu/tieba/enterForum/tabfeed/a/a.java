package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.a<bw, al<bw>> {
    private aa<bw> aeT;
    private v akI;
    public BdUniqueId ePv;
    private NEGFeedBackView.a flJ;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new aa<bw>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                s.cbX().kK(true);
                com.baidu.tieba.enterForum.a.a(view, bwVar, a.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.ePv = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<bw> b(ViewGroup viewGroup) {
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
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.tP().bs(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        aj a = aVar.a(true, viewGroup, this.akI);
        a.setSourceForPb(2);
        al<bw> alVar = new al<>(a);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, al<bw> alVar) {
        if (bwVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        bwVar.dZb = getPositionByType(i) + 1;
        alVar.tR().setPosition(i);
        alVar.aL(true).a(this.flJ);
        alVar.a(true, Align.ALIGN_RIGHT_BOTTOM);
        alVar.b((al<bw>) bwVar);
        alVar.tR().a(this.aeT);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.enterForum.a.a(bwVar, this.mTabName);
        return alVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.f) && (view.getTag() instanceof al)) {
            com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) qVar;
            fVar.objType = 1;
            ay.a((AbsThreadDataSupport) fVar, view.getContext(), 2, false);
            ((al) view.getTag()).tR().b(new a.C0095a(1));
        }
    }

    public void a(v vVar) {
        this.akI = vVar;
    }
}
