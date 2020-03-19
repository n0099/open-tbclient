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
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OT;
    public BdUniqueId dBK;
    private NEGFeedBackView.a dUT;
    private al gZo;
    private com.baidu.tieba.homepage.personalize.model.e heO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gZo != null && this.gZo.np() != null && this.gZo.np().cyL() != null) {
            if (view.getId() == this.gZo.np().cyL().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRt, this.dBK, lVar.bvw(), 4);
                TiebaStatic.log(lVar.bvO());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ag(lVar.cRt));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUT = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bvm().id(true);
                com.baidu.tieba.a.d.aXK().cu("page_recommend", "show_");
                if (z.this.heO != null && lVar != null && lVar.aAj() != null && !StringUtils.isNull(lVar.aAj().getTid())) {
                    if (lVar.aAj().cUc > 0) {
                        TiebaStatic.log(lVar.ag(lVar.aAj()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L));
                        z.this.heO.a(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bvw(), lVar.bvx(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aAj().getBaijiahaoData());
                    }
                    z.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bPl();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OT = rVar;
    }

    private void bPl() {
        com.baidu.tieba.card.data.l.fNN = "c10708";
        com.baidu.tieba.card.data.l.fNO = "c10735";
        com.baidu.tieba.card.data.l.fOl = "c10709";
        com.baidu.tieba.card.data.l.fNM = "c10734";
        com.baidu.tieba.card.data.l.fOm = "c11929";
        com.baidu.tieba.card.data.l.fOn = "c11928";
        com.baidu.tieba.card.data.l.fOo = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
            cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.z.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar2) {
                    if (aVar2 != null) {
                        Rect aP = au.aP(cVar.getVideoContainer());
                        if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                            au.a(aVar2, z.this.mContext, 2, false, aP);
                            return;
                        }
                        aVar2.objType = 5;
                        au.a(aVar2, z.this.mContext, 2, false, aP);
                    }
                }
            });
            this.gZo = cVar;
        } else {
            this.gZo = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity());
        }
        this.gZo.setPageUniqueId(this.dBK);
        this.gZo.setFrom("index");
        aVar.c(this.gZo);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.OT);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.dBK);
        a.a(this.JZ);
        a.aQ(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (z.this.JZ != null) {
                        z.this.JZ.a(aVar3.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    aVar3.nk().b(new a.C0052a(1));
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
        lVar.rv(lVar.position + 1);
        aVar.nk().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bvm().e(lVar.bvH());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.nk() != null) {
            aVar.nk().setPage(this.LC);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a(this.JZ);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRt, this.dBK, lVar.bvw());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.Pk = lVar.tid;
            if (lVar.aAj() != null) {
                yVar.emF = String.valueOf(lVar.aAj().getFid());
                if (lVar.aAj().aCI() != null) {
                    yVar.jyv = lVar.aAj().aCI().video_md5;
                    yVar.jyx = String.valueOf(lVar.aAj().aCI().is_vertical);
                }
            }
            yVar.cPf = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.bvx();
            yVar.jys = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bvw());
            if (lVar.aAj() != null && lVar.aAj().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aAj().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aAj().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.heO = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wQ(String str) {
        this.LC = str;
    }

    public void onResume() {
        if (this.gZo != null) {
            this.gZo.onResume();
        }
    }

    public void onPause() {
        if (this.gZo != null) {
            this.gZo.onPause();
        }
    }
}
