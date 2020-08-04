package com.baidu.tieba.homepage.concern.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.ar;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> adN;
    private String afx;
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private ar hol;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.hol != null && this.hol.sl() != null && this.hol.sl().cYJ() != null) {
            if (view.getId() == this.hol.sl().cYJ().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
            }
        }
    }

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                if (lVar != null && lVar.aTN() != null && !StringUtils.isNull(lVar.aTN().getTid())) {
                    if (lVar.aTN().dUg <= 0) {
                        w.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.af(lVar.aTN()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.eEU);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.w.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aW = ax.aW(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.l)) {
                        ax.a(absThreadDataSupport, w.this.mContext, 1, false, aW);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ax.a(absThreadDataSupport, w.this.mContext, 1, false, aW);
                }
            }
        });
        this.hol = cVar;
        aVar.c(this.hol);
        ai a = aVar.a(false, viewGroup, this.ajt);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eEU);
        a.a(this.adN);
        a.setSourceForPb(1);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.w.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ak)) {
                    ak akVar = (ak) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (w.this.adN != null) {
                        w.this.adN.a(akVar.getView(), lVar);
                    }
                    ax.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar.sg().b(new a.C0096a(1));
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
        lVar.tj(lVar.position + 1);
        com.baidu.tieba.card.s.bRL().e(lVar.EF("c12351"));
        aVar.sg().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.sg() instanceof com.baidu.tieba.a.e) {
            aVar.sg().setPage(this.afx);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.sg().a(this.adN);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.ajJ = lVar.tid;
            if (lVar.aTN() != null) {
                oVar.eKO = String.valueOf(lVar.aTN().getFid());
                if (lVar.aTN().aWD() != null) {
                    oVar.lcO = lVar.aTN().aWD().video_md5;
                    oVar.lcQ = String.valueOf(lVar.aTN().aWD().is_vertical);
                }
            }
            oVar.dOV = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.lcN = lVar.bRY();
            oVar.lcK = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.bRX());
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}
