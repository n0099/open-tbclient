package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes16.dex */
public class f extends com.baidu.adp.widget.ListView.a<k, ak<k>> {
    private aa<k> adN;
    private v ajt;
    private BdUniqueId eEU;
    private int eeE;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new aa<k>() { // from class: com.baidu.tieba.homepage.gamevideo.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                int id = view.getId();
                if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                    com.baidu.tieba.homepage.gamevideo.e.a.c(kVar, f.this.eeE);
                } else if (id == R.id.user_avatar) {
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, f.this.eeE);
                } else if (id == R.id.user_name) {
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, f.this.eeE);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.bg(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.gamevideo.a.f.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
            }
        });
        aVar.a(eVar);
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(18);
        ak<k> akVar = new ak<>(a);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.homepage.gamevideo.a.f.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (f.this.adN != null) {
                        f.this.adN.a(akVar2.getView(), kVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(kVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ak<k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLK == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        akVar.sg().setPosition(i);
        akVar.b((ak<k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        return akVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eEU = bdUniqueId;
    }

    public void xw(int i) {
        this.eeE = i;
    }
}
