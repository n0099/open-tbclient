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
/* loaded from: classes9.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> JZ;
    private String LC;
    private boolean NJ;
    public BdUniqueId dBk;
    private NEGFeedBackView.a dUq;
    private com.baidu.tieba.card.k hdG;
    private com.baidu.tieba.homepage.personalize.model.e hdl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.af(lVar.cRf));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.bvD());
            i = 0;
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.af(lVar.cRf));
            TiebaStatic.log(lVar.bvI());
            i = 4;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.ag(lVar.cRf));
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.ag(lVar.cRf));
            i = 2;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.af(lVar.cRf));
            i = 5;
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.X("obj_locate", 4);
            TiebaStatic.log(anVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.X("obj_locate", 2);
            TiebaStatic.log(anVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.X("obj_locate", 1);
            TiebaStatic.log(anVar3);
            i = 0;
        } else {
            if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                an anVar4 = new an("c10760");
                anVar4.X("obj_locate", 3);
                TiebaStatic.log(anVar4);
            }
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRf, this.dBk, lVar.bvq(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUq = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bvg().ib(true);
                com.baidu.tieba.a.d.aXF().cv("page_recommend", "show_");
                if (y.this.hdl != null && lVar != null && lVar.aAg() != null && !StringUtils.isNull(lVar.aAg().getTid())) {
                    if (lVar.aAg().cTO > 0) {
                        TiebaStatic.log(lVar.af(lVar.aAg()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.aAg().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.aAg().getTid(), 0L));
                        y.this.hdl.a(com.baidu.adp.lib.f.b.toLong(lVar.aAg().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bvq(), lVar.bvr(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aAg().getBaijiahaoData());
                    }
                    y.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bOW();
    }

    private void bOW() {
        com.baidu.tieba.card.data.l.fMS = "c10708";
        com.baidu.tieba.card.data.l.fMT = "c10735";
        com.baidu.tieba.card.data.l.fNq = "c10709";
        com.baidu.tieba.card.data.l.fMR = "c10734";
        com.baidu.tieba.card.data.l.fNr = "c11929";
        com.baidu.tieba.card.data.l.fNs = "c11928";
        com.baidu.tieba.card.data.l.fNt = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        al bVar;
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBk);
        eVar.aL(1024);
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
        bVar.setPageUniqueId(this.dBk);
        bVar.setFrom("index");
        aVar.c(bVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NJ);
        kVar.setForm("index");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 1;
        dVar.cNC = 2;
        dVar.cNH = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        aVar.b(agVar);
        ad nj = aVar.nj();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(nj);
        aVar2.setPageId(this.dBk);
        nj.a(this.JZ);
        nj.aQ(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.y.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (y.this.JZ != null) {
                        y.this.JZ.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    afVar.nk().b(new a.C0052a(1));
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
        lVar.rt(lVar.position + 1);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bvg().d(lVar.bvB());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.nk() != null) {
            aVar.nk().setPage(this.LC);
        }
        com.baidu.card.w ag = aVar.ag(true);
        ag.a(this.dUq);
        ag.A(lVar.aAi());
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a(this.JZ);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRf, this.dBk, lVar.bvq());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.Pj = lVar.tid;
            if (lVar.aAg() != null) {
                yVar.emb = String.valueOf(lVar.aAg().getFid());
                if (lVar.aAg().aCF() != null) {
                    yVar.jwK = lVar.aAg().aCF().video_md5;
                    yVar.jwM = String.valueOf(lVar.aAg().aCF().is_vertical);
                }
            }
            yVar.cOR = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.bvr();
            yVar.jwH = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bvq());
            if (lVar.aAg() != null && lVar.aAg().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aAg().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aAg().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUq = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hdl = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void onDestroy() {
        if (this.hdG != null) {
            this.hdG.onDestroy();
        }
    }

    public void onPause() {
        if (this.hdG != null) {
            this.hdG.onPause();
        }
    }

    public void onResume() {
        if (this.hdG != null) {
            this.hdG.onResume();
        }
    }
}
