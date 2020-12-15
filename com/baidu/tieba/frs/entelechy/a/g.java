package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class g extends com.baidu.adp.widget.ListView.a<bx, com.baidu.card.am<by>> {
    public BdUniqueId fzO;
    private BdTypeRecyclerView jdl;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.fzO = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.tO();
        aVar.a((com.baidu.card.i) sVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.jdl);
        a2.setSourceForPb(2);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (qVar instanceof bx) {
                    bx bxVar = (bx) qVar;
                    if (bxVar.eCR != null && bxVar.eIK && bxVar.eCR.bqV() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemID", String.valueOf(bxVar.eCR.bqV().item_id));
                        hashMap.put("source", 3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                        return;
                    }
                }
                if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 2, false);
                    ((com.baidu.card.am) view.getTag()).tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.am<by> amVar) {
        if (bxVar == null || amVar == null || amVar.getView() == null || bxVar.eCR == null) {
            return null;
        }
        bxVar.eCR.eHa = getPositionByType(i) + 1;
        amVar.tZ().setPosition(i);
        amVar.b((com.baidu.card.am<by>) bxVar.eCR);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        this.jdl = bdTypeRecyclerView;
    }
}
