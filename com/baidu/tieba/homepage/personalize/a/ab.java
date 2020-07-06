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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> adX;
    private String afG;
    private com.baidu.adp.widget.ListView.v ajy;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private ar hiC;
    private com.baidu.tieba.homepage.personalize.model.e iti;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.hiC != null && this.hiC.sj() != null && this.hiC.sj().cUV() != null) {
            if (view.getId() == this.hiC.sj().cUV().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.dLi, this.eyE, lVar.bOM(), 4);
                TiebaStatic.log(lVar.bPf());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ai(lVar.dLi));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eTW = null;
        this.adX = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.bOB().jI(true);
                com.baidu.tieba.a.d.boB().dh("page_recommend", "show_");
                if (ab.this.iti != null && lVar != null && lVar.aPS() != null && !StringUtils.isNull(lVar.aPS().getTid())) {
                    if (lVar.aPS().dNV > 0) {
                        TiebaStatic.log(lVar.ai(lVar.aPS()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eq(com.baidu.adp.lib.f.b.toLong(lVar.aPS().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ep(com.baidu.adp.lib.f.b.toLong(lVar.aPS().getTid(), 0L));
                        ab.this.iti.a(com.baidu.adp.lib.f.b.toLong(lVar.aPS().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bOM(), lVar.bON(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aPS().getBaijiahaoData());
                    }
                    ab.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cjQ();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }

    private void cjQ() {
        com.baidu.tieba.card.data.l.gUA = "c10708";
        com.baidu.tieba.card.data.l.gUB = "c10735";
        com.baidu.tieba.card.data.l.gUU = "c10709";
        com.baidu.tieba.card.data.l.gUz = "c10734";
        com.baidu.tieba.card.data.l.gUV = "c11929";
        com.baidu.tieba.card.data.l.gUW = "c11928";
        com.baidu.tieba.card.data.l.gUX = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = aw.aQ(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.l)) {
                        aw.a(absThreadDataSupport, ab.this.mContext, 2, false, aQ);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    aw.a(absThreadDataSupport, ab.this.mContext, 2, false, aQ);
                }
            }
        });
        this.hiC = cVar;
        this.hiC.setPageUniqueId(this.eyE);
        this.hiC.setFrom("index");
        aVar.c(this.hiC);
        ai a = aVar.a(false, viewGroup, this.ajy);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eyE);
        a.a(this.adX);
        a.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ak)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (ab.this.adX != null) {
                        ab.this.adX.a(aVar3.getView(), lVar);
                    }
                    aw.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.se().b(new a.C0098a(1));
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
        lVar.sR(lVar.position + 1);
        aVar.se().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.s.bOB().e(lVar.bOY());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.se() != null) {
            aVar.se().setPage(this.afG);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.se().a(this.adX);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dLi, this.eyE, lVar.bOM());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.ajO = lVar.tid;
            if (lVar.aPS() != null) {
                yVar.eEs = String.valueOf(lVar.aPS().getFid());
                yVar.kVx = lVar.aPS().getNid();
                if (lVar.aPS().aSH() != null) {
                    yVar.kVt = lVar.aPS().aSH().video_md5;
                    yVar.kVv = String.valueOf(lVar.aPS().aSH().is_vertical);
                }
            }
            yVar.dIK = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kVs = lVar.bON();
            yVar.kVp = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bOM());
            if (lVar.aPS() != null && lVar.aPS().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aPS().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aPS().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iti = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void onResume() {
        if (this.hiC != null) {
            this.hiC.onResume();
        }
    }

    public void onPause() {
        if (this.hiC != null) {
            this.hiC.onPause();
        }
    }
}
