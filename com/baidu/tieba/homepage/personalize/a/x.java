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
    public BdUniqueId dBx;
    private NEGFeedBackView.a dUD;
    private al gYh;
    private com.baidu.tieba.homepage.personalize.model.e hdx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gYh != null && this.gYh.np() != null && this.gYh.np().cys() != null) {
            if (view.getId() == this.gYh.np().cys().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRg, this.dBx, lVar.bvr(), 4);
                TiebaStatic.log(lVar.bvJ());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.af(lVar.cRg));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUD = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bvh().ib(true);
                com.baidu.tieba.a.d.aXG().cv("page_recommend", "show_");
                if (x.this.hdx != null && lVar != null && lVar.aAg() != null && !StringUtils.isNull(lVar.aAg().getTid())) {
                    if (lVar.aAg().cTP > 0) {
                        TiebaStatic.log(lVar.af(lVar.aAg()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.aAg().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.aAg().getTid(), 0L));
                        x.this.hdx.a(com.baidu.adp.lib.f.b.toLong(lVar.aAg().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bvr(), lVar.bvs(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aAg().getBaijiahaoData());
                    }
                    x.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bOX();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OR = rVar;
    }

    private void bOX() {
        com.baidu.tieba.card.data.l.fNf = "c10708";
        com.baidu.tieba.card.data.l.fNg = "c10735";
        com.baidu.tieba.card.data.l.fND = "c10709";
        com.baidu.tieba.card.data.l.fNe = "c10734";
        com.baidu.tieba.card.data.l.fNE = "c11929";
        com.baidu.tieba.card.data.l.fNF = "c11928";
        com.baidu.tieba.card.data.l.fNG = "c10756";
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
            this.gYh = aVar2;
        } else {
            this.gYh = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.gYh.setPageUniqueId(this.dBx);
        this.gYh.setFrom("index");
        aVar.c(this.gYh);
        ad a = aVar.a(false, viewGroup, this.OR);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar3 = new com.baidu.card.a<>(a);
        aVar3.setPageId(this.dBx);
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
        com.baidu.tieba.card.r.bvh().d(lVar.bvC());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.nk() != null) {
            aVar.nk().setPage(this.LC);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a(this.JZ);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRg, this.dBx, lVar.bvr());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.Pj = lVar.tid;
            if (lVar.aAg() != null) {
                yVar.emo = String.valueOf(lVar.aAg().getFid());
                if (lVar.aAg().aCF() != null) {
                    yVar.jwW = lVar.aAg().aCF().video_md5;
                    yVar.jwY = String.valueOf(lVar.aAg().aCF().is_vertical);
                }
            }
            yVar.cOS = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.bvs();
            yVar.jwT = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bvr());
            if (lVar.aAg() != null && lVar.aAg().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aAg().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aAg().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hdx = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    public void onResume() {
        if (this.gYh != null) {
            this.gYh.onResume();
        }
    }

    public void onPause() {
        if (this.gYh != null) {
            this.gYh.onPause();
        }
    }
}
