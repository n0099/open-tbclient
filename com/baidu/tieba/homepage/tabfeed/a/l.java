package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class l extends com.baidu.adp.widget.ListView.a<bx, am<by>> {
    private v amH;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.fzO = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.i) new aa(this.mPageContext.getPageActivity()));
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am<by> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.l.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    az.a((com.baidu.tbadk.core.data.a) ((com.baidu.tieba.card.data.k) qVar), view.getContext(), 2, false);
                    ((am) view.getTag()).tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, am<by> amVar) {
        if (bxVar == null || amVar == null || amVar.getView() == null || bxVar.eCR == null) {
            return null;
        }
        bxVar.eCR.eHa = getPositionByType(i) + 1;
        amVar.tZ().setPosition(i);
        amVar.b((am<by>) bxVar.eCR);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    public void a(v vVar) {
        this.amH = vVar;
    }
}
