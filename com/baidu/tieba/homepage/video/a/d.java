package com.baidu.tieba.homepage.video.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.h;
import com.baidu.card.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, ag<k>> {
    private aa<k> adt;
    private t aib;
    private BdUniqueId epM;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<k>() { // from class: com.baidu.tieba.homepage.video.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aOi() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.video.c.a.m(kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(t tVar) {
        this.aib = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<k> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        l lVar = new l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(true);
        lVar.setForm("video_tab");
        aVar.a((h) lVar);
        ae a = aVar.a(false, viewGroup, this.aib);
        a.setSourceForPb(19);
        ag<k> agVar = new ag<>(a);
        agVar.setPageId(this.epM);
        a(new x() { // from class: com.baidu.tieba.homepage.video.a.d.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    k kVar = (k) oVar;
                    kVar.objType = 1;
                    if (d.this.adt != null) {
                        d.this.adt.a(agVar2.getView(), kVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(kVar, view.getContext(), 19, false, com.baidu.card.f.a((t) viewGroup2, view, i));
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ag<k> agVar) {
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.sr(kVar.position + 1);
        agVar.rM().setPosition(i);
        agVar.b((ag<k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        return agVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.epM = bdUniqueId;
    }
}
