package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<k, z<k>> {
    private ab<k> VB;
    private r YY;
    private int bXG;
    private NEGFeedBackView.a cTD;
    private BdUniqueId cyA;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VB = new ab<k>() { // from class: com.baidu.tieba.homepage.gamevideo.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, k kVar) {
                int id = view.getId();
                if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                    com.baidu.tieba.homepage.gamevideo.e.a.c(kVar, f.this.bXG);
                } else if (id == R.id.user_avatar) {
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, f.this.bXG);
                } else if (id == R.id.user_name) {
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, f.this.bXG);
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
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cyA);
        dVar.bn(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.gamevideo.a.f.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
            }
        });
        aVar.c(dVar);
        x a = aVar.a(false, viewGroup, this.YY);
        a.bq(18);
        z<k> zVar = new z<>(a);
        zVar.setPageId(this.cyA);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.gamevideo.a.f.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (f.this.VB != null) {
                        f.this.VB.a(zVar2.getView(), kVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, view.getContext(), 18, false);
                    zVar2.qQ().b(new a.C0038a(1));
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
        kVar.pN(kVar.position + 1);
        zVar.qQ().setPosition(i);
        zVar.qR().a(this.cTD);
        zVar.a(kVar);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.VB);
        return zVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cyA = bdUniqueId;
    }

    public void ud(int i) {
        this.bXG = i;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cTD = aVar;
    }
}
