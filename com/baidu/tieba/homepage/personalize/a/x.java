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
/* loaded from: classes6.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> Jy;
    private String La;
    private com.baidu.adp.widget.ListView.r Ol;
    private NEGFeedBackView.a dQa;
    public BdUniqueId dwY;
    private al gSy;
    private com.baidu.tieba.homepage.personalize.model.e gXL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gSy != null && this.gSy.mX() != null && this.gSy.mX().cvN() != null) {
            if (view.getId() == this.gSy.mX().cvN().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.cMR, this.dwY, lVar.bsI(), 4);
                TiebaStatic.log(lVar.bta());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ad(lVar.cMR));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQa = null;
        this.Jy = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bsy().hK(true);
                com.baidu.tieba.a.d.aUV().cm("page_recommend", "show_");
                if (x.this.gXL != null && lVar != null && lVar.axx() != null && !StringUtils.isNull(lVar.axx().getTid())) {
                    if (lVar.axx().cPB > 0) {
                        TiebaStatic.log(lVar.ad(lVar.axx()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dy(com.baidu.adp.lib.f.b.toLong(lVar.axx().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dx(com.baidu.adp.lib.f.b.toLong(lVar.axx().getTid(), 0L));
                        x.this.gXL.a(com.baidu.adp.lib.f.b.toLong(lVar.axx().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bsI(), lVar.bsJ(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.axx().getBaijiahaoData());
                    }
                    x.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bMk();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Ol = rVar;
    }

    private void bMk() {
        com.baidu.tieba.card.data.l.fHk = "c10708";
        com.baidu.tieba.card.data.l.fHl = "c10735";
        com.baidu.tieba.card.data.l.fHI = "c10709";
        com.baidu.tieba.card.data.l.fHj = "c10734";
        com.baidu.tieba.card.data.l.fHJ = "c11929";
        com.baidu.tieba.card.data.l.fHK = "c11928";
        com.baidu.tieba.card.data.l.fHL = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final com.baidu.tieba.homepage.personalize.view.a aVar2 = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
            aVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar3) {
                    if (aVar3 != null) {
                        Rect aL = au.aL(aVar2.getVideoContainer());
                        if (!(aVar3 instanceof com.baidu.tieba.card.data.l)) {
                            au.a(aVar3, x.this.mContext, 2, false, aL);
                            return;
                        }
                        aVar3.objType = 5;
                        au.a(aVar3, x.this.mContext, 2, false, aL);
                    }
                }
            });
            this.gSy = aVar2;
        } else {
            this.gSy = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.gSy.setPageUniqueId(this.dwY);
        this.gSy.setFrom("index");
        aVar.c(this.gSy);
        ad a = aVar.a(false, viewGroup, this.Ol);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar3 = new com.baidu.card.a<>(a);
        aVar3.setPageId(this.dwY);
        a.a(this.Jy);
        a.aM(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.x.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar4 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (x.this.Jy != null) {
                        x.this.Jy.a(aVar4.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    aVar4.mT().b(new a.C0050a(1));
                }
            }
        });
        return aVar3;
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
        lVar.rh(lVar.position + 1);
        aVar.mT().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bsy().c(lVar.bsT());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.mT() != null) {
            aVar.mT().setPage(this.La);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.mT().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mT().a(this.Jy);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.cMR, this.dwY, lVar.bsI());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.OC = lVar.tid;
            if (lVar.axx() != null) {
                yVar.fGQ = String.valueOf(lVar.axx().getFid());
                if (lVar.axx().azV() != null) {
                    yVar.jsl = lVar.axx().azV().video_md5;
                    yVar.jsn = String.valueOf(lVar.axx().azV().is_vertical);
                }
            }
            yVar.cKC = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.bsJ();
            yVar.jsj = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bsI());
            if (lVar.axx() != null && lVar.axx().getBaijiahaoData() != null) {
                yVar.mNid = lVar.axx().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.axx().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gXL = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }

    public void onResume() {
        if (this.gSy != null) {
            this.gSy.onResume();
        }
    }

    public void onPause() {
        if (this.gSy != null) {
            this.gSy.onPause();
        }
    }
}
