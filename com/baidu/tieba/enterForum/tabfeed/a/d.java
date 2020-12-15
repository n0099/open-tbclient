package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<bx, am<by>> {
    private ab<by> agG;
    private boolean alo;
    private v amH;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alo = true;
        this.agG = new ab<by>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                t.csh().mj(true);
                com.baidu.tieba.enterForum.a.a(view, byVar, d.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fzO = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.amH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        y yVar = new y(this.mPageContext.getPageActivity());
        yVar.setFrom("index");
        yVar.setFromCDN(this.alo);
        aVar.c(yVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.d.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (d.this.agG != null) {
                        d.this.agG.a(amVar2.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 2, false);
                    amVar2.tZ().b(new a.C0097a(1));
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
        amVar.tZ().a(this.agG);
        com.baidu.tieba.enterForum.a.a(bxVar, this.mTabName);
        y yVar = (y) amVar.tZ().tS();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.ahJ.alN.getLayoutParams();
        layoutParams.width = bxVar.eIP;
        layoutParams.height = bxVar.eIQ;
        if (yVar.ahJ.alN.getVisibility() != 8) {
            yVar.ahJ.alN.setLayoutParams(layoutParams);
        }
        return amVar.getView();
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }
}
