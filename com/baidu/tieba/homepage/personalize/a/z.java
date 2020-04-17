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
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> acX;
    private String aey;
    private com.baidu.adp.widget.ListView.r ahv;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    private al gGN;
    private com.baidu.tieba.homepage.personalize.model.e hOB;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gGN != null && this.gGN.rI() != null && this.gGN.rI().cJq() != null) {
            if (view.getId() == this.gGN.rI().cJq().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.dqA, this.ebv, lVar.bFh(), 4);
                TiebaStatic.log(lVar.bFz());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ag(lVar.dqA));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euS = null;
        this.acX = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bEY().jd(true);
                com.baidu.tieba.a.d.bfP().cF("page_recommend", "show_");
                if (z.this.hOB != null && lVar != null && lVar.aIw() != null && !StringUtils.isNull(lVar.aIw().getTid())) {
                    if (lVar.aIw().dtm > 0) {
                        TiebaStatic.log(lVar.ag(lVar.aIw()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.el(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L));
                        z.this.hOB.a(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bFh(), lVar.bFi(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aIw().getBaijiahaoData());
                    }
                    z.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZM();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahv = rVar;
    }

    private void bZM() {
        com.baidu.tieba.card.data.l.gsu = "c10708";
        com.baidu.tieba.card.data.l.gsv = "c10735";
        com.baidu.tieba.card.data.l.gsS = "c10709";
        com.baidu.tieba.card.data.l.gst = "c10734";
        com.baidu.tieba.card.data.l.gsT = "c11929";
        com.baidu.tieba.card.data.l.gsU = "c11928";
        com.baidu.tieba.card.data.l.gsV = "c10756";
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
            this.gGN = cVar;
        } else {
            this.gGN = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity());
        }
        this.gGN.setPageUniqueId(this.ebv);
        this.gGN.setFrom("index");
        aVar.c(this.gGN);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.ahv);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebv);
        a.a(this.acX);
        a.bc(2);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.z.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (z.this.acX != null) {
                        z.this.acX.a(aVar3.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    aVar3.rD().b(new a.C0074a(1));
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
        com.baidu.tieba.card.r.bEY().e(lVar.bFs());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.rD() != null) {
            aVar.rD().setPage(this.aey);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.acX);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dqA, this.ebv, lVar.bFh());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.ahL = lVar.tid;
            if (lVar.aIw() != null) {
                yVar.eQf = String.valueOf(lVar.aIw().getFid());
                if (lVar.aIw().aKV() != null) {
                    yVar.kis = lVar.aIw().aKV().video_md5;
                    yVar.kiu = String.valueOf(lVar.aIw().aKV().is_vertical);
                }
            }
            yVar.dol = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kir = lVar.bFi();
            yVar.kio = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bFh());
            if (lVar.aIw() != null && lVar.aIw().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aIw().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aIw().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hOB = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    public void onResume() {
        if (this.gGN != null) {
            this.gGN.onResume();
        }
    }

    public void onPause() {
        if (this.gGN != null) {
            this.gGN.onPause();
        }
    }
}
