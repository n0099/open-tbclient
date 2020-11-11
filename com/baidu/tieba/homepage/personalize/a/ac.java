package com.baidu.tieba.homepage.personalize.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.m> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    private NEGFeedBackView.a fPf;
    public BdUniqueId fsQ;
    private at ipE;
    private com.baidu.tieba.homepage.personalize.model.e jEn;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.ipE != null && this.ipE.uc() != null && this.ipE.uc().dwP() != null) {
            if (view.getId() == this.ipE.uc().dwP().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(mVar.exA, this.fsQ, mVar.coD(), 4);
                TiebaStatic.log(mVar.coW());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(mVar.ag(mVar.exA));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fPf = null;
        this.afF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.t.cor().lN(true);
                com.baidu.tieba.a.d.bIR().dM("page_recommend", "show_");
                if (ac.this.jEn != null && mVar != null && mVar.bjZ() != null && !StringUtils.isNull(mVar.bjZ().getTid())) {
                    if (mVar.bjZ().eGl > 0) {
                        TiebaStatic.log(mVar.ag(mVar.bjZ()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fS(com.baidu.adp.lib.f.b.toLong(mVar.bjZ().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fR(com.baidu.adp.lib.f.b.toLong(mVar.bjZ().getTid(), 0L));
                        ac.this.jEn.a(com.baidu.adp.lib.f.b.toLong(mVar.bjZ().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.coD(), mVar.coE(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", mVar.bjZ().getBaijiahaoData());
                    }
                    ac.this.a(view, mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIV();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }

    private void cIV() {
        com.baidu.tieba.card.data.m.ibt = "c10708";
        com.baidu.tieba.card.data.m.ibu = "c10735";
        com.baidu.tieba.card.data.m.ibM = "c10709";
        com.baidu.tieba.card.data.m.ibs = "c10734";
        com.baidu.tieba.card.data.m.ibN = "c11929";
        com.baidu.tieba.card.data.m.ibO = "c11928";
        com.baidu.tieba.card.data.m.ibP = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ac.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bh = ay.bh(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, ac.this.mContext, 2, false, bh);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ac.this.mContext, 2, false, bh);
                }
            }
        });
        this.ipE = cVar;
        this.ipE.setPageUniqueId(this.fsQ);
        this.ipE.setFrom("index");
        this.ipE.setStageType("2001");
        aVar.c(this.ipE);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsQ);
        a2.a(this.afF);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ac.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (ac.this.afF != null) {
                        ac.this.afF.a(aVar3.getView(), mVar);
                    }
                    ay.a((AbsThreadDataSupport) mVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.tW().b(new a.C0097a(1));
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
        mVar.xj(mVar.position + 1);
        aVar.tW().setPosition(i);
        mVar.sourceType = 0;
        com.baidu.tieba.card.t.cor().e(mVar.coP());
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tW() != null) {
            aVar.tW().setPage(this.ahu);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afF);
        com.baidu.tieba.homepage.personalize.c.a.a(mVar.exA, this.fsQ, mVar.coD());
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.play.o oVar = null;
        if (mVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.alT = mVar.tid;
            if (mVar.bjZ() != null) {
                oVar.fyR = String.valueOf(mVar.bjZ().getFid());
                oVar.mka = mVar.bjZ().getNid();
                if (mVar.bjZ().bmS() != null) {
                    oVar.mjW = mVar.bjZ().bmS().video_md5;
                    oVar.mjY = String.valueOf(mVar.bjZ().bmS().is_vertical);
                }
            }
            oVar.eAX = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.mjV = mVar.coE();
            oVar.mjS = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.coD());
            if (mVar.bjZ() != null && mVar.bjZ().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bjZ().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bjZ().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jEn = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    public void onResume() {
        if (this.ipE != null) {
            this.ipE.onResume();
        }
    }

    public void onPause() {
        if (this.ipE != null) {
            this.ipE.onPause();
        }
    }
}
