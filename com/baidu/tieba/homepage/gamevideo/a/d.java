package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.h;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.widget.ListView.a<l, al<l>> {
    private aa<l> aeT;
    private v akI;
    private BdUniqueId ePv;
    private int eoe;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new aa<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.akI = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<l> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        m mVar = new m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(true);
        mVar.setForm(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.a((h) mVar);
        aj a = aVar.a(false, viewGroup, this.akI);
        a.setSourceForPb(18);
        al<l> alVar = new al<>(a);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.d.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (d.this.aeT != null) {
                        d.this.aeT.a(alVar2.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, al<l> alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.tR().setPosition(i);
        alVar.b((al<l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        return alVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ePv = bdUniqueId;
    }

    public void zQ(int i) {
        this.eoe = i;
    }
}
