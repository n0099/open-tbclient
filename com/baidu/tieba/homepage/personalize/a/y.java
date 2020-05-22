package com.baidu.tieba.homepage.personalize.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.am;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> adt;
    private String aeX;
    private com.baidu.adp.widget.ListView.t aib;
    private NEGFeedBackView.a eJz;
    public BdUniqueId epM;
    private am gVA;
    private com.baidu.tieba.homepage.personalize.model.e idp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gVA != null && this.gVA.rR() != null && this.gVA.rR().cQn() != null) {
            if (view.getId() == this.gVA.rR().cQn().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.dEA, this.epM, lVar.bLz(), 4);
                TiebaStatic.log(lVar.bLS());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ah(lVar.dEA));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eJz = null;
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.bLq().jv(true);
                com.baidu.tieba.a.d.blZ().de("page_recommend", "show_");
                if (y.this.idp != null && lVar != null && lVar.aOi() != null && !StringUtils.isNull(lVar.aOi().getTid())) {
                    if (lVar.aOi().dHk > 0) {
                        TiebaStatic.log(lVar.ah(lVar.aOi()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.en(com.baidu.adp.lib.f.b.toLong(lVar.aOi().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(lVar.aOi().getTid(), 0L));
                        y.this.idp.a(com.baidu.adp.lib.f.b.toLong(lVar.aOi().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bLz(), lVar.bLA(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aOi().getBaijiahaoData());
                    }
                    y.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cgg();
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.aib = tVar;
    }

    private void cgg() {
        com.baidu.tieba.card.data.l.gHp = "c10708";
        com.baidu.tieba.card.data.l.gHq = "c10735";
        com.baidu.tieba.card.data.l.gHJ = "c10709";
        com.baidu.tieba.card.data.l.gHo = "c10734";
        com.baidu.tieba.card.data.l.gHK = "c11929";
        com.baidu.tieba.card.data.l.gHL = "c11928";
        com.baidu.tieba.card.data.l.gHM = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
            cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.y.2
                @Override // com.baidu.card.b.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (absThreadDataSupport != null) {
                        Rect aQ = au.aQ(cVar.getVideoContainer());
                        if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.l)) {
                            au.a(absThreadDataSupport, y.this.mContext, 2, false, aQ);
                            return;
                        }
                        absThreadDataSupport.objType = 5;
                        au.a(absThreadDataSupport, y.this.mContext, 2, false, aQ);
                    }
                }
            });
            this.gVA = cVar;
        } else {
            this.gVA = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity());
        }
        this.gVA.setPageUniqueId(this.epM);
        this.gVA.setFrom("index");
        aVar.c(this.gVA);
        ae a = aVar.a(false, viewGroup, this.aib);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.epM);
        a.a(this.adt);
        a.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.y.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ag)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) oVar;
                    lVar.objType = 1;
                    if (y.this.adt != null) {
                        y.this.adt.a(aVar3.getView(), lVar);
                    }
                    au.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
                    aVar3.rM().b(new a.C0097a(1));
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
        lVar.sr(lVar.position + 1);
        aVar.rM().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.s.bLq().e(lVar.bLL());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.rM() != null) {
            aVar.rM().setPage(this.aeX);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a(this.adt);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dEA, this.epM, lVar.bLz());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.ais = lVar.tid;
            if (lVar.aOi() != null) {
                yVar.evm = String.valueOf(lVar.aOi().getFid());
                yVar.kAu = lVar.aOi().getNid();
                if (lVar.aOi().aQQ() != null) {
                    yVar.kAq = lVar.aOi().aQQ().video_md5;
                    yVar.kAs = String.valueOf(lVar.aOi().aQQ().is_vertical);
                }
            }
            yVar.dCp = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kAp = lVar.bLA();
            yVar.kAm = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bLz());
            if (lVar.aOi() != null && lVar.aOi().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aOi().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aOi().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.idp = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void onResume() {
        if (this.gVA != null) {
            this.gVA.onResume();
        }
    }

    public void onPause() {
        if (this.gVA != null) {
            this.gVA.onPause();
        }
    }
}
