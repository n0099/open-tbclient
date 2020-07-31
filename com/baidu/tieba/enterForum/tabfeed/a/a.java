package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.a<bv, ak<bv>> {
    private aa<bv> adN;
    private v ajt;
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new aa<bv>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                s.bRL().km(true);
                com.baidu.tieba.enterForum.a.a(view, bvVar, a.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.eEU = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 1;
        cVar.dNH = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(1);
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        aVar.b(alVar);
        aVar.se().bm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.se().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.se().bn(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        ai a = aVar.a(true, viewGroup, this.ajt);
        a.setSourceForPb(2);
        ak<bv> akVar = new ak<>(a);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, ak<bv> akVar) {
        if (bvVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        bvVar.dPI = getPositionByType(i) + 1;
        akVar.sg().setPosition(i);
        akVar.aK(true).a(this.far);
        akVar.a(true, Align.ALIGN_RIGHT_BOTTOM);
        akVar.b((ak<bv>) bvVar);
        akVar.sg().a(this.adN);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.enterForum.a.a(bvVar, this.mTabName);
        return akVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ak)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) qVar;
            eVar.objType = 1;
            ax.a((AbsThreadDataSupport) eVar, view.getContext(), 2, false);
            ((ak) view.getTag()).sg().b(new a.C0096a(1));
        }
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }
}
