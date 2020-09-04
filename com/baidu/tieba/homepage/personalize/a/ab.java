package com.baidu.tieba.homepage.personalize.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.m> aeV;
    private String agJ;
    private com.baidu.adp.widget.ListView.v akK;
    public BdUniqueId ePz;
    private NEGFeedBackView.a flN;
    private as hBi;
    private com.baidu.tieba.homepage.personalize.model.e iOm;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.hBi != null && this.hBi.tW() != null && this.hBi.tW().djP() != null) {
            if (view.getId() == this.hBi.tW().djP().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(mVar.dUW, this.ePz, mVar.cck(), 4);
                TiebaStatic.log(mVar.ccD());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(mVar.af(mVar.dUW));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.flN = null;
        this.aeV = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.s.cbY().kM(true);
                com.baidu.tieba.a.d.bAB().dA("page_recommend", "show_");
                if (ab.this.iOm != null && mVar != null && mVar.bce() != null && !StringUtils.isNull(mVar.bce().getTid())) {
                    if (mVar.bce().edG > 0) {
                        TiebaStatic.log(mVar.af(mVar.bce()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eP(com.baidu.adp.lib.f.b.toLong(mVar.bce().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eO(com.baidu.adp.lib.f.b.toLong(mVar.bce().getTid(), 0L));
                        ab.this.iOm.a(com.baidu.adp.lib.f.b.toLong(mVar.bce().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.cck(), mVar.ccl(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", mVar.bce().getBaijiahaoData());
                    }
                    ab.this.a(view, mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cyl();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akK = vVar;
    }

    private void cyl() {
        com.baidu.tieba.card.data.m.hnb = "c10708";
        com.baidu.tieba.card.data.m.hnc = "c10735";
        com.baidu.tieba.card.data.m.hnt = "c10709";
        com.baidu.tieba.card.data.m.hna = "c10734";
        com.baidu.tieba.card.data.m.hnu = "c11929";
        com.baidu.tieba.card.data.m.hnv = "c11928";
        com.baidu.tieba.card.data.m.hnw = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aY = ay.aY(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, 2, false, aY);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, 2, false, aY);
                }
            }
        });
        this.hBi = cVar;
        this.hBi.setPageUniqueId(this.ePz);
        this.hBi.setFrom("index");
        this.hBi.setStageType("2001");
        aVar.c(this.hBi);
        aj a = aVar.a(false, viewGroup, this.akK);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ePz);
        a.a(this.aeV);
        a.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof al)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (ab.this.aeV != null) {
                        ab.this.aeV.a(aVar3.getView(), mVar);
                    }
                    ay.a((AbsThreadDataSupport) mVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.tR().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.card.a<com.baidu.tieba.card.data.m> aVar) {
        if (mVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        mVar.vy(mVar.position + 1);
        aVar.tR().setPosition(i);
        mVar.sourceType = 0;
        com.baidu.tieba.card.s.cbY().e(mVar.ccw());
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tR() != null) {
            aVar.tR().setPage(this.agJ);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.aeV);
        com.baidu.tieba.homepage.personalize.c.a.a(mVar.dUW, this.ePz, mVar.cck());
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.play.o oVar = null;
        if (mVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.ala = mVar.tid;
            if (mVar.bce() != null) {
                oVar.eVx = String.valueOf(mVar.bce().getFid());
                oVar.ltx = mVar.bce().getNid();
                if (mVar.bce().beW() != null) {
                    oVar.ltt = mVar.bce().beW().video_md5;
                    oVar.ltv = String.valueOf(mVar.bce().beW().is_vertical);
                }
            }
            oVar.dYs = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.lts = mVar.ccl();
            oVar.lto = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.cck());
            if (mVar.bce() != null && mVar.bce().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bce().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bce().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iOm = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
        this.agJ = str;
    }

    public void onResume() {
        if (this.hBi != null) {
            this.hBi.onResume();
        }
    }

    public void onPause() {
        if (this.hBi != null) {
            this.hBi.onPause();
        }
    }
}
