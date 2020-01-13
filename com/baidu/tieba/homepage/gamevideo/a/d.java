package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes7.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, af<k>> {
    private z<k> JE;
    private r Oq;
    private int cZk;
    private BdUniqueId dxg;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JE = new z<k>() { // from class: com.baidu.tieba.homepage.gamevideo.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, k kVar) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.Oq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(true);
        kVar.setForm(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.a((h) kVar);
        ad a = aVar.a(false, viewGroup, this.Oq);
        a.aM(18);
        af<k> afVar = new af<>(a);
        afVar.setPageId(this.dxg);
        a(new s() { // from class: com.baidu.tieba.homepage.gamevideo.a.d.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    k kVar2 = (k) mVar;
                    kVar2.objType = 1;
                    if (d.this.JE != null) {
                        d.this.JE.a(afVar2.getView(), kVar2);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar2, view.getContext(), 18, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, af<k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cNb == null) {
            return null;
        }
        kVar.rm(kVar.position + 1);
        afVar.mU().setPosition(i);
        afVar.b((af<k>) kVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.JE);
        return afVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dxg = bdUniqueId;
    }

    public void vf(int i) {
        this.cZk = i;
    }
}
