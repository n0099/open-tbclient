package com.baidu.tieba.homepage.personalize.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class z extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> ada;
    private String aeB;
    private com.baidu.adp.widget.ListView.r ahy;
    public BdUniqueId ebA;
    private NEGFeedBackView.a euX;
    private al gGT;
    private com.baidu.tieba.homepage.personalize.model.e hOH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gGT != null && this.gGT.rI() != null && this.gGT.rI().cJn() != null) {
            if (view.getId() == this.gGT.rI().cJn().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.dqE, this.ebA, lVar.bFf(), 4);
                TiebaStatic.log(lVar.bFx());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ag(lVar.dqE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euX = null;
        this.ada = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bEW().jd(true);
                com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
                if (z.this.hOH != null && lVar != null && lVar.aIu() != null && !StringUtils.isNull(lVar.aIu().getTid())) {
                    if (lVar.aIu().dtq > 0) {
                        TiebaStatic.log(lVar.ag(lVar.aIu()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(lVar.aIu().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.el(com.baidu.adp.lib.f.b.toLong(lVar.aIu().getTid(), 0L));
                        z.this.hOH.a(com.baidu.adp.lib.f.b.toLong(lVar.aIu().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bFf(), lVar.bFg(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aIu().getBaijiahaoData());
                    }
                    z.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZK();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahy = rVar;
    }

    private void bZK() {
        com.baidu.tieba.card.data.l.gsA = "c10708";
        com.baidu.tieba.card.data.l.gsB = "c10735";
        com.baidu.tieba.card.data.l.gsY = "c10709";
        com.baidu.tieba.card.data.l.gsz = "c10734";
        com.baidu.tieba.card.data.l.gsZ = "c11929";
        com.baidu.tieba.card.data.l.gta = "c11928";
        com.baidu.tieba.card.data.l.gtb = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
            cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.z.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar2) {
                    if (aVar2 != null) {
                        Rect aQ = au.aQ(cVar.getVideoContainer());
                        if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                            au.a(aVar2, z.this.mContext, 2, false, aQ);
                            return;
                        }
                        aVar2.objType = 5;
                        au.a(aVar2, z.this.mContext, 2, false, aQ);
                    }
                }
            });
            this.gGT = cVar;
        } else {
            this.gGT = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity());
        }
        this.gGT.setPageUniqueId(this.ebA);
        this.gGT.setFrom("index");
        aVar.c(this.gGT);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.ahy);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebA);
        a.a(this.ada);
        a.bc(2);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.z.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (z.this.ada != null) {
                        z.this.ada.a(aVar3.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    aVar3.rD().b(new a.C0095a(1));
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
        aVar.rD().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bEW().e(lVar.bFq());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.rD() != null) {
            aVar.rD().setPage(this.aeB);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.ada);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dqE, this.ebA, lVar.bFf());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
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
            yVar.kiv = lVar.bFg();
            yVar.kis = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bFf());
            if (lVar.aIu() != null && lVar.aIu().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aIu().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aIu().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hOH = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    public void onResume() {
        if (this.gGT != null) {
            this.gGT.onResume();
        }
    }

    public void onPause() {
        if (this.gGT != null) {
            this.gGT.onPause();
        }
    }
}
