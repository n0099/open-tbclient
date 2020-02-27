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
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OR;
    public BdUniqueId dBj;
    private NEGFeedBackView.a dUp;
    private al gXT;
    private com.baidu.tieba.homepage.personalize.model.e hdj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gXT != null && this.gXT.np() != null && this.gXT.np().cyp() != null) {
            if (view.getId() == this.gXT.np().cyp().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRe, this.dBj, lVar.bvo(), 4);
                TiebaStatic.log(lVar.bvG());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.af(lVar.cRe));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUp = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bve().ib(true);
                com.baidu.tieba.a.d.aXD().cv("page_recommend", "show_");
                if (x.this.hdj != null && lVar != null && lVar.aAe() != null && !StringUtils.isNull(lVar.aAe().getTid())) {
                    if (lVar.aAe().cTN > 0) {
                        TiebaStatic.log(lVar.af(lVar.aAe()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.aAe().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.aAe().getTid(), 0L));
                        x.this.hdj.a(com.baidu.adp.lib.f.b.toLong(lVar.aAe().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bvo(), lVar.bvp(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aAe().getBaijiahaoData());
                    }
                    x.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bOU();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OR = rVar;
    }

    private void bOU() {
        com.baidu.tieba.card.data.l.fMQ = "c10708";
        com.baidu.tieba.card.data.l.fMR = "c10735";
        com.baidu.tieba.card.data.l.fNo = "c10709";
        com.baidu.tieba.card.data.l.fMP = "c10734";
        com.baidu.tieba.card.data.l.fNp = "c11929";
        com.baidu.tieba.card.data.l.fNq = "c11928";
        com.baidu.tieba.card.data.l.fNr = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final com.baidu.tieba.homepage.personalize.view.a aVar2 = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
            aVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar3) {
                    if (aVar3 != null) {
                        Rect aP = au.aP(aVar2.getVideoContainer());
                        if (!(aVar3 instanceof com.baidu.tieba.card.data.l)) {
                            au.a(aVar3, x.this.mContext, 2, false, aP);
                            return;
                        }
                        aVar3.objType = 5;
                        au.a(aVar3, x.this.mContext, 2, false, aP);
                    }
                }
            });
            this.gXT = aVar2;
        } else {
            this.gXT = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.gXT.setPageUniqueId(this.dBj);
        this.gXT.setFrom("index");
        aVar.c(this.gXT);
        ad a = aVar.a(false, viewGroup, this.OR);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar3 = new com.baidu.card.a<>(a);
        aVar3.setPageId(this.dBj);
        a.a(this.JZ);
        a.aQ(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.x.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar4 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (x.this.JZ != null) {
                        x.this.JZ.a(aVar4.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    aVar4.nk().b(new a.C0052a(1));
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
        lVar.rt(lVar.position + 1);
        aVar.nk().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bve().d(lVar.bvz());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.nk() != null) {
            aVar.nk().setPage(this.LC);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a(this.JZ);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRe, this.dBj, lVar.bvo());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.Pj = lVar.tid;
            if (lVar.aAe() != null) {
                yVar.ema = String.valueOf(lVar.aAe().getFid());
                if (lVar.aAe().aCD() != null) {
                    yVar.jwI = lVar.aAe().aCD().video_md5;
                    yVar.jwK = String.valueOf(lVar.aAe().aCD().is_vertical);
                }
            }
            yVar.cOQ = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.bvp();
            yVar.jwF = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bvo());
            if (lVar.aAe() != null && lVar.aAe().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aAe().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aAe().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hdj = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    public void onResume() {
        if (this.gXT != null) {
            this.gXT.onResume();
        }
    }

    public void onPause() {
        if (this.gXT != null) {
            this.gXT.onPause();
        }
    }
}
