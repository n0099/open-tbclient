package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, z<k>> {
    private ab<k> VC;
    private r YY;
    private int bWH;
    private BdUniqueId cxx;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VC = new ab<k>() { // from class: com.baidu.tieba.homepage.gamevideo.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, k kVar) {
                int id = view.getId();
                if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                    com.baidu.tieba.homepage.gamevideo.e.a.c(kVar, e.this.bWH);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.YY = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z<k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFz = 15;
        dVar.bFE = 11;
        aaVar.setAgreeStatisticData(dVar);
        aaVar.setFrom(12);
        aaVar.setShareReportFrom(9);
        aaVar.setGameId(this.bWH);
        aaVar.bw(18);
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(true, viewGroup, this.YY);
        a.bq(18);
        z<k> zVar = new z<>(a);
        zVar.setPageId(this.cxx);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.gamevideo.a.e.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (e.this.VC != null) {
                        e.this.VC.a(zVar2.getView(), kVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, view.getContext(), 18, false);
                    zVar2.qP().b(new a.C0038a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, z<k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.threadData == null) {
            return null;
        }
        kVar.pI(kVar.position + 1);
        zVar.qP().setPosition(i);
        zVar.a(kVar);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.VC);
        return zVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cxx = bdUniqueId;
    }

    public void tX(int i) {
        this.bWH = i;
    }
}
