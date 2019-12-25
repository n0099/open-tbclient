package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> Jy;
    private String La;
    private boolean Nf;
    private NEGFeedBackView.a dQa;
    public BdUniqueId dwY;
    private com.baidu.tieba.homepage.personalize.model.e gXL;
    private com.baidu.tieba.card.k gYg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.ad(lVar.cMR));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.bsV());
            i = 0;
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.ad(lVar.cMR));
            TiebaStatic.log(lVar.bta());
            i = 4;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.ae(lVar.cMR));
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.ae(lVar.cMR));
            i = 2;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.ad(lVar.cMR));
            i = 5;
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.Z("obj_locate", 4);
            TiebaStatic.log(anVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.Z("obj_locate", 2);
            TiebaStatic.log(anVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.Z("obj_locate", 1);
            TiebaStatic.log(anVar3);
            i = 0;
        } else {
            if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                an anVar4 = new an("c10760");
                anVar4.Z("obj_locate", 3);
                TiebaStatic.log(anVar4);
            }
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.cMR, this.dwY, lVar.bsI(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQa = null;
        this.Jy = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bsy().hK(true);
                com.baidu.tieba.a.d.aUV().cm("page_recommend", "show_");
                if (y.this.gXL != null && lVar != null && lVar.axx() != null && !StringUtils.isNull(lVar.axx().getTid())) {
                    if (lVar.axx().cPB > 0) {
                        TiebaStatic.log(lVar.ad(lVar.axx()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dy(com.baidu.adp.lib.f.b.toLong(lVar.axx().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dx(com.baidu.adp.lib.f.b.toLong(lVar.axx().getTid(), 0L));
                        y.this.gXL.a(com.baidu.adp.lib.f.b.toLong(lVar.axx().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bsI(), lVar.bsJ(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.axx().getBaijiahaoData());
                    }
                    y.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bMk();
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
        al bVar;
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dwY);
        eVar.aI(1024);
        aVar.a(eVar);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            bVar = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
            bVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.y.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar2) {
                    if (aVar2 != null) {
                        if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                            au.a(aVar2, y.this.mContext, 2, false);
                            return;
                        }
                        aVar2.objType = 5;
                        au.a(aVar2, y.this.mContext, 2, false);
                    }
                }
            });
        } else {
            bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        bVar.setPageUniqueId(this.dwY);
        bVar.setFrom("index");
        aVar.c(bVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Nf);
        kVar.setForm("index");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 1;
        dVar.cJn = 2;
        dVar.cJs = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aV(2);
        aVar.b(agVar);
        ad mS = aVar.mS();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(mS);
        aVar2.setPageId(this.dwY);
        mS.a(this.Jy);
        mS.aM(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.y.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (y.this.Jy != null) {
                        y.this.Jy.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    afVar.mT().b(new a.C0050a(1));
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
        lVar.rh(lVar.position + 1);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bsy().c(lVar.bsT());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.mT() != null) {
            aVar.mT().setPage(this.La);
        }
        com.baidu.card.w ad = aVar.ad(true);
        ad.a(this.dQa);
        ad.A(lVar.axz());
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQa = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gXL = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void onDestroy() {
        if (this.gYg != null) {
            this.gYg.onDestroy();
        }
    }

    public void onPause() {
        if (this.gYg != null) {
            this.gYg.onPause();
        }
    }

    public void onResume() {
        if (this.gYg != null) {
            this.gYg.onResume();
        }
    }
}
