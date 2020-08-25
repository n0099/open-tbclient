package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.widget.ListView.a<bv, al<bw>> {
    private aa<bw> aeT;
    private boolean ajr;
    private v akI;
    public BdUniqueId ePv;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = true;
        this.aeT = new aa<bw>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                s.cbX().kK(true);
                com.baidu.tieba.enterForum.a.a(view, bwVar, d.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.ePv = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.akI = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        x xVar = new x(this.mPageContext.getPageActivity());
        xVar.setFrom("index");
        xVar.setFromCDN(this.ajr);
        aVar.c(xVar);
        aj a = aVar.a(false, viewGroup, this.akI);
        a.setSourceForPb(2);
        al alVar = new al(a);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.d.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    bw bwVar = ((bv) qVar).dUS;
                    bwVar.objType = 1;
                    if (d.this.aeT != null) {
                        d.this.aeT.a(alVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, al<bw> alVar) {
        if (bvVar == null || alVar == null || alVar.getView() == null || bvVar.dUS == null) {
            return null;
        }
        bvVar.dUS.dZb = getPositionByType(i) + 1;
        alVar.tR().setPosition(i);
        alVar.b((al<bw>) bvVar.dUS);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        com.baidu.tieba.enterForum.a.a(bvVar, this.mTabName);
        x xVar = (x) alVar.tR().tK();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) xVar.afU.ajZ.getLayoutParams();
        layoutParams.width = bvVar.eaP;
        layoutParams.height = bvVar.eaQ;
        if (xVar.afU.ajZ.getVisibility() != 8) {
            xVar.afU.ajZ.setLayoutParams(layoutParams);
        }
        return alVar.getView();
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }
}
