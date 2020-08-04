package com.baidu.tieba.homepage.personalize.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> adN;
    private String afx;
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    private ar hol;
    private com.baidu.tieba.homepage.personalize.model.e izo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.hol != null && this.hol.sl() != null && this.hol.sl().cYJ() != null) {
            if (view.getId() == this.hol.sl().cYJ().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.dLK, this.eEU, lVar.bRX(), 4);
                TiebaStatic.log(lVar.bSq());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.af(lVar.dLK));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.far = null;
        this.adN = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                if (ab.this.izo != null && lVar != null && lVar.aTN() != null && !StringUtils.isNull(lVar.aTN().getTid())) {
                    if (lVar.aTN().dUg > 0) {
                        TiebaStatic.log(lVar.af(lVar.aTN()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eD(com.baidu.adp.lib.f.b.toLong(lVar.aTN().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eC(com.baidu.adp.lib.f.b.toLong(lVar.aTN().getTid(), 0L));
                        ab.this.izo.a(com.baidu.adp.lib.f.b.toLong(lVar.aTN().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bRX(), lVar.bRY(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aTN().getBaijiahaoData());
                    }
                    ab.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cnr();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajt = vVar;
    }

    private void cnr() {
        com.baidu.tieba.card.data.l.hae = "c10708";
        com.baidu.tieba.card.data.l.haf = "c10735";
        com.baidu.tieba.card.data.l.hay = "c10709";
        com.baidu.tieba.card.data.l.had = "c10734";
        com.baidu.tieba.card.data.l.haz = "c11929";
        com.baidu.tieba.card.data.l.haA = "c11928";
        com.baidu.tieba.card.data.l.haB = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aW = ax.aW(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.l)) {
                        ax.a(absThreadDataSupport, ab.this.mContext, 2, false, aW);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ax.a(absThreadDataSupport, ab.this.mContext, 2, false, aW);
                }
            }
        });
        this.hol = cVar;
        this.hol.setPageUniqueId(this.eEU);
        this.hol.setFrom("index");
        aVar.c(this.hol);
        ai a = aVar.a(false, viewGroup, this.ajt);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eEU);
        a.a(this.adN);
        a.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ak)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (ab.this.adN != null) {
                        ab.this.adN.a(aVar3.getView(), lVar);
                    }
                    ax.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.sg().b(new a.C0096a(1));
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
        aVar.sg().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.s.bRL().e(lVar.bSj());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.sg() != null) {
            aVar.sg().setPage(this.afx);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.sg().a(this.adN);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dLK, this.eEU, lVar.bRX());
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
                oVar.lcS = lVar.aTN().getNid();
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
            if (lVar.aTN() != null && lVar.aTN().getBaijiahaoData() != null) {
                oVar.mNid = lVar.aTN().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.aTN().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.izo = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void onResume() {
        if (this.hol != null) {
            this.hol.onResume();
        }
    }

    public void onPause() {
        if (this.hol != null) {
            this.hol.onPause();
        }
    }
}
