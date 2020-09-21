package com.baidu.tieba.homepage.video.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<l, am<l>> {
    private aa<l> afn;
    private v alj;
    private BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afn = new aa<l>() { // from class: com.baidu.tieba.homepage.video.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bcY() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.video.c.a.p(lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.alj = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 21;
        cVar.dYZ = 2;
        cVar.dZe = 18;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(16);
        anVar.setShareReportFrom(10);
        anVar.setFromForPb(19);
        anVar.bo(32);
        aVar.b(anVar);
        ak a = aVar.a(true, viewGroup, this.alj);
        a.setSourceForPb(19);
        am<l> amVar = new am<>(a);
        amVar.setPageId(this.eSq);
        a(new ab() { // from class: com.baidu.tieba.homepage.video.a.e.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (e.this.afn != null) {
                        e.this.afn.a(amVar2.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, am<l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.dXg == null) {
            return null;
        }
        lVar.vX(lVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.aL(false).a(this.foG);
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.foG);
        amVar.b((am<l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        return amVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eSq = bdUniqueId;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.foG = aVar;
    }
}
