package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Fq;
    private String GC;
    private r IY;
    public BdUniqueId cKf;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Fq = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.agI() != null && !StringUtils.isNull(kVar.agI().getTid())) {
                    l.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.IY = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, false);
        } else if (id == R.id.user_avatar) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, true);
        } else if (id == R.id.user_name) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cKf);
        dVar.aB(128);
        dVar.aC(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.concern.a.l.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        x a = aVar.a(false, viewGroup, this.IY);
        a.aF(1);
        z zVar = new z(a);
        zVar.setPageId(this.cKf);
        a(new s() { // from class: com.baidu.tieba.homepage.concern.a.l.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (l.this.Fq != null) {
                        l.this.Fq.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.cbq == null) {
            return null;
        }
        kVar.oP(kVar.position + 1);
        zVar.lV().setPosition(i);
        if (zVar.lV() instanceof com.baidu.tieba.a.e) {
            zVar.lV().setPage(this.GC);
        }
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.Fq);
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }
}
