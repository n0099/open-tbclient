package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes9.dex */
public class t extends com.baidu.tieba.frs.j<bt, com.baidu.card.ak<bu>> implements com.baidu.adp.widget.ListView.z, com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afG;
    private int hID;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hID = 3;
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.y(this.mPageContext.getPageActivity()));
        com.baidu.card.ai a = aVar.a(false, viewGroup, this.hfK);
        a.setSourceForPb(3);
        com.baidu.card.ak<bu> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        a(this);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, com.baidu.card.ak<bu> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) btVar, (bt) akVar);
        if (btVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.se().setPage(this.afG);
        akVar.se().setPosition(i);
        akVar.b((com.baidu.card.ak<bu>) btVar.dLi);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        btVar.dLi.aTB();
        return akVar.getView();
    }

    @Override // com.baidu.adp.widget.ListView.z
    public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((qVar instanceof bt) && (view.getTag() instanceof com.baidu.card.ak)) {
            bu buVar = ((bt) qVar).dLi;
            buVar.objType = 1;
            aw.a((AbsThreadDataSupport) buVar, view.getContext(), this.hID, false);
            ((com.baidu.card.ak) view.getTag()).se().b(new a.C0098a(1));
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.hID = i;
    }

    @Override // com.baidu.tieba.card.z
    public void me(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hIE;
    }
}
