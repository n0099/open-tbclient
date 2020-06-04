package com.baidu.tieba.homepage.concern.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.am;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> adt;
    private String aeX;
    private com.baidu.adp.widget.ListView.t aib;
    public BdUniqueId epM;
    private am gVL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gVL != null && this.gVL.rR() != null && this.gVL.rR().cQD() != null) {
            if (view.getId() == this.gVL.rR().cQD().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
            }
        }
    }

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.bLs().jv(true);
                com.baidu.tieba.a.d.bmb().de("page_recommend", "show_");
                if (lVar != null && lVar.aOi() != null && !StringUtils.isNull(lVar.aOi().getTid())) {
                    if (lVar.aOi().dHk <= 0) {
                        t.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ah(lVar.aOi()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.aib = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.epM);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.t.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = au.aQ(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.l)) {
                        au.a(absThreadDataSupport, t.this.mContext, 1, false, aQ);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    au.a(absThreadDataSupport, t.this.mContext, 1, false, aQ);
                }
            }
        });
        this.gVL = cVar;
        aVar.c(this.gVL);
        ae a = aVar.a(false, viewGroup, this.aib);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.epM);
        a.a(this.adt);
        a.setSourceForPb(1);
        a(new x() { // from class: com.baidu.tieba.homepage.concern.a.t.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ag)) {
                    ag agVar = (ag) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) oVar;
                    lVar.objType = 1;
                    if (t.this.adt != null) {
                        t.this.adt.a(agVar.getView(), lVar);
                    }
                    au.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
                    agVar.rM().b(new a.C0097a(1));
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
        lVar.st(lVar.position + 1);
        com.baidu.tieba.card.s.bLs().e(lVar.Dt("c12351"));
        aVar.rM().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.rM() instanceof com.baidu.tieba.a.e) {
            aVar.rM().setPage(this.aeX);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a(this.adt);
        return aVar.getView();
    }

    private y c(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.ais = lVar.tid;
            if (lVar.aOi() != null) {
                yVar.evm = String.valueOf(lVar.aOi().getFid());
                if (lVar.aOi().aQQ() != null) {
                    yVar.kBw = lVar.aOi().aQQ().video_md5;
                    yVar.kBy = String.valueOf(lVar.aOi().aQQ().is_vertical);
                }
            }
            yVar.dCp = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kBv = lVar.bLC();
            yVar.kBs = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bLB());
        }
        return yVar;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }
}
