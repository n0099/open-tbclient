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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> afK;
    private String ahw;
    private com.baidu.adp.widget.ListView.v alH;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    private at iqs;
    private com.baidu.tieba.homepage.personalize.model.e jFl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iqs != null && this.iqs.uc() != null && this.iqs.uc().dwp() != null) {
            if (view.getId() == this.iqs.uc().dwp().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.evQ, this.fsa, lVar.cof(), 4);
                TiebaStatic.log(lVar.cox());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ai(lVar.evQ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fOM = null;
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.cnT().lO(true);
                com.baidu.tieba.a.d.bIl().dL("page_recommend", "show_");
                if (ac.this.jFl != null && lVar != null && lVar.bjd() != null && !StringUtils.isNull(lVar.bjd().getTid())) {
                    if (lVar.bjd().eED > 0) {
                        TiebaStatic.log(lVar.ai(lVar.bjd()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fV(com.baidu.adp.lib.f.b.toLong(lVar.bjd().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fU(com.baidu.adp.lib.f.b.toLong(lVar.bjd().getTid(), 0L));
                        ac.this.jFl.a(com.baidu.adp.lib.f.b.toLong(lVar.bjd().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.cof(), lVar.cog(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bjd().getBaijiahaoData());
                    }
                    ac.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIA();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }

    private void cIA() {
        com.baidu.tieba.card.data.l.icl = "c10708";
        com.baidu.tieba.card.data.l.icm = "c10735";
        com.baidu.tieba.card.data.l.icB = "c10709";
        com.baidu.tieba.card.data.l.ick = "c10734";
        com.baidu.tieba.card.data.l.icC = "c11929";
        com.baidu.tieba.card.data.l.icD = "c11928";
        com.baidu.tieba.card.data.l.icE = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ac.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bk = az.bk(cVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        az.a(aVar2, ac.this.mContext, 2, false, bk);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, ac.this.mContext, 2, false, bk);
                }
            }
        });
        this.iqs = cVar;
        this.iqs.setPageUniqueId(this.fsa);
        this.iqs.setFrom("index");
        this.iqs.setStageType("2001");
        aVar.c(this.iqs);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.alH);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsa);
        a2.a(this.afK);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ac.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (ac.this.afK != null) {
                        ac.this.afK.a(aVar3.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.tW().b(new a.C0096a(1));
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
        lVar.xH(lVar.position + 1);
        aVar.tW().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.t.cnT().e(lVar.coo());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.tW() != null) {
            aVar.tW().setPage(this.ahw);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afK);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.evQ, this.fsa, lVar.cof());
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.alZ = lVar.tid;
            if (lVar.bjd() != null) {
                oVar.fyg = String.valueOf(lVar.bjd().getFid());
                oVar.mkt = lVar.bjd().getNid();
                if (lVar.bjd().blU() != null) {
                    oVar.mkp = lVar.bjd().blU().video_md5;
                    oVar.mkr = String.valueOf(lVar.bjd().blU().is_vertical);
                }
            }
            oVar.ezo = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mko = lVar.cog();
            oVar.mkl = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.cof());
            if (lVar.bjd() != null && lVar.bjd().getBaijiahaoData() != null) {
                oVar.mNid = lVar.bjd().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bjd().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jFl = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void onResume() {
        if (this.iqs != null) {
            this.iqs.onResume();
        }
    }

    public void onPause() {
        if (this.iqs != null) {
            this.iqs.onPause();
        }
    }
}
