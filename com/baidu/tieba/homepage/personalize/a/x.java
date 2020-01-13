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
/* loaded from: classes7.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> JE;
    private String Lg;
    private com.baidu.adp.widget.ListView.r Oq;
    private NEGFeedBackView.a dQj;
    public BdUniqueId dxg;
    private al gVS;
    private com.baidu.tieba.homepage.personalize.model.e hbj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gVS != null && this.gVS.mY() != null && this.gVS.mY().cwU() != null) {
            if (view.getId() == this.gVS.mY().cwU().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.cNb, this.dxg, lVar.btK(), 4);
                TiebaStatic.log(lVar.buc());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ae(lVar.cNb));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQj = null;
        this.JE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                if (x.this.hbj != null && lVar != null && lVar.axQ() != null && !StringUtils.isNull(lVar.axQ().getTid())) {
                    if (lVar.axQ().cPL > 0) {
                        TiebaStatic.log(lVar.ae(lVar.axQ()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.axQ().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.axQ().getTid(), 0L));
                        x.this.hbj.a(com.baidu.adp.lib.f.b.toLong(lVar.axQ().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.btK(), lVar.btL(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.axQ().getBaijiahaoData());
                    }
                    x.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bNs();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Oq = rVar;
    }

    private void bNs() {
        com.baidu.tieba.card.data.l.fKu = "c10708";
        com.baidu.tieba.card.data.l.fKv = "c10735";
        com.baidu.tieba.card.data.l.fKS = "c10709";
        com.baidu.tieba.card.data.l.fKt = "c10734";
        com.baidu.tieba.card.data.l.fKT = "c11929";
        com.baidu.tieba.card.data.l.fKU = "c11928";
        com.baidu.tieba.card.data.l.fKV = "c10756";
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
            this.gVS = aVar2;
        } else {
            this.gVS = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.gVS.setPageUniqueId(this.dxg);
        this.gVS.setFrom("index");
        aVar.c(this.gVS);
        ad a = aVar.a(false, viewGroup, this.Oq);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar3 = new com.baidu.card.a<>(a);
        aVar3.setPageId(this.dxg);
        a.a(this.JE);
        a.aM(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.x.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar4 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (x.this.JE != null) {
                        x.this.JE.a(aVar4.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    aVar4.mU().b(new a.C0050a(1));
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
        lVar.rm(lVar.position + 1);
        aVar.mU().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.btA().c(lVar.btV());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.mU() != null) {
            aVar.mU().setPage(this.Lg);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mU().a(this.JE);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.cNb, this.dxg, lVar.btK());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.OG = lVar.tid;
            if (lVar.axQ() != null) {
                yVar.fKa = String.valueOf(lVar.axQ().getFid());
                if (lVar.axQ().aAo() != null) {
                    yVar.jvN = lVar.axQ().aAo().video_md5;
                    yVar.jvP = String.valueOf(lVar.axQ().aAo().is_vertical);
                }
            }
            yVar.cKN = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.btL();
            yVar.jvK = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.btK());
            if (lVar.axQ() != null && lVar.axQ().getBaijiahaoData() != null) {
                yVar.mNid = lVar.axQ().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.axQ().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hbj = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void onResume() {
        if (this.gVS != null) {
            this.gVS.onResume();
        }
    }

    public void onPause() {
        if (this.gVS != null) {
            this.gVS.onPause();
        }
    }
}
