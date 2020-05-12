package com.baidu.tieba.homepage.concern.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.l> ada;
    private String aeB;
    private com.baidu.adp.widget.ListView.r ahy;
    public BdUniqueId ebA;
    private al gGT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gGT != null && this.gGT.rI() != null && this.gGT.rI().cJo() != null) {
            if (view.getId() == this.gGT.rI().cJo().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
            }
        }
    }

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ada = new z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bEX().jd(true);
                com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
                if (lVar != null && lVar.aIu() != null && !StringUtils.isNull(lVar.aIu().getTid())) {
                    if (lVar.aIu().dtq <= 0) {
                        t.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ag(lVar.aIu()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahy = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.ebA);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.t.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aQ = au.aQ(cVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        au.a(aVar2, t.this.mContext, 1, false, aQ);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, t.this.mContext, 1, false, aQ);
                }
            }
        });
        this.gGT = cVar;
        aVar.c(this.gGT);
        ad a = aVar.a(false, viewGroup, this.ahy);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebA);
        a.a(this.ada);
        a.bc(1);
        a(new v() { // from class: com.baidu.tieba.homepage.concern.a.t.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (t.this.ada != null) {
                        t.this.ada.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.rD().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.rN(lVar.position + 1);
        com.baidu.tieba.card.r.bEX().e(lVar.BK("c12351"));
        aVar.rD().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.rD() instanceof com.baidu.tieba.a.e) {
            aVar.rD().setPage(this.aeB);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.ada);
        return aVar.getView();
    }

    private y c(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.ahO = lVar.tid;
            if (lVar.aIu() != null) {
                yVar.eQk = String.valueOf(lVar.aIu().getFid());
                if (lVar.aIu().aKT() != null) {
                    yVar.kiw = lVar.aIu().aKT().video_md5;
                    yVar.kiy = String.valueOf(lVar.aIu().aKT().is_vertical);
                }
            }
            yVar.dop = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kiv = lVar.bFh();
            yVar.kis = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bFg());
        }
        return yVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }
}
