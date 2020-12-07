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
/* loaded from: classes22.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> agG;
    private String aiw;
    private com.baidu.adp.widget.ListView.v amH;
    private NEGFeedBackView.a fWA;
    public BdUniqueId fzO;
    private at iBk;
    private com.baidu.tieba.homepage.personalize.model.e jSO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iBk != null && this.iBk.uf() != null && this.iBk.uf().dBH() != null) {
            if (view.getId() == this.iBk.uf().dBH().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.eCR, this.fzO, lVar.css(), 4);
                TiebaStatic.log(lVar.csK());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ai(lVar.eCR));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWA = null;
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.csg().mj(true);
                com.baidu.tieba.a.d.bLT().dS("page_recommend", "show_");
                if (ac.this.jSO != null && lVar != null && lVar.bmn() != null && !StringUtils.isNull(lVar.bmn().getTid())) {
                    if (lVar.bmn().eLF > 0) {
                        TiebaStatic.log(lVar.ai(lVar.bmn()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(lVar.bmn().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(lVar.bmn().getTid(), 0L));
                        ac.this.jSO.a(com.baidu.adp.lib.f.b.toLong(lVar.bmn().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.css(), lVar.cst(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bmn().getBaijiahaoData());
                    }
                    ac.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNP();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }

    private void cNP() {
        com.baidu.tieba.card.data.l.ini = "c10708";
        com.baidu.tieba.card.data.l.inj = "c10735";
        com.baidu.tieba.card.data.l.inz = "c10709";
        com.baidu.tieba.card.data.l.inh = "c10734";
        com.baidu.tieba.card.data.l.inA = "c11929";
        com.baidu.tieba.card.data.l.inB = "c11928";
        com.baidu.tieba.card.data.l.inC = "c10756";
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
                    Rect bn = az.bn(cVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        az.a(aVar2, ac.this.mContext, 2, false, bn);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, ac.this.mContext, 2, false, bn);
                }
            }
        });
        this.iBk = cVar;
        this.iBk.setPageUniqueId(this.fzO);
        this.iBk.setFrom("index");
        this.iBk.setStageType("2001");
        aVar.c(this.iBk);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fzO);
        a2.a(this.agG);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ac.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (ac.this.agG != null) {
                        ac.this.agG.a(aVar3.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.tZ().b(new a.C0097a(1));
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
        lVar.ym(lVar.position + 1);
        aVar.tZ().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.t.csg().e(lVar.csB());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.tZ() != null) {
            aVar.tZ().setPage(this.aiw);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tZ().a(this.agG);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.eCR, this.fzO, lVar.css());
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.amY = lVar.tid;
            if (lVar.bmn() != null) {
                oVar.fFV = String.valueOf(lVar.bmn().getFid());
                oVar.myx = lVar.bmn().getNid();
                if (lVar.bmn().bph() != null) {
                    oVar.myt = lVar.bmn().bph().video_md5;
                    oVar.myv = String.valueOf(lVar.bmn().bph().is_vertical);
                }
            }
            oVar.eGn = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mys = lVar.cst();
            oVar.myp = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.css());
            if (lVar.bmn() != null && lVar.bmn().getBaijiahaoData() != null) {
                oVar.mNid = lVar.bmn().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bmn().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jSO = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void onResume() {
        if (this.iBk != null) {
            this.iBk.onResume();
        }
    }

    public void onPause() {
        if (this.iBk != null) {
            this.iBk.onPause();
        }
    }
}
