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
/* loaded from: classes7.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> JE;
    private String Lg;
    private boolean Nj;
    private NEGFeedBackView.a dQj;
    public BdUniqueId dxg;
    private com.baidu.tieba.card.k hbE;
    private com.baidu.tieba.homepage.personalize.model.e hbj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.ae(lVar.cNb));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.btX());
            i = 0;
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.ae(lVar.cNb));
            TiebaStatic.log(lVar.buc());
            i = 4;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.af(lVar.cNb));
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.af(lVar.cNb));
            i = 2;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.ae(lVar.cNb));
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
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.cNb, this.dxg, lVar.btK(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQj = null;
        this.JE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                if (y.this.hbj != null && lVar != null && lVar.axQ() != null && !StringUtils.isNull(lVar.axQ().getTid())) {
                    if (lVar.axQ().cPL > 0) {
                        TiebaStatic.log(lVar.ae(lVar.axQ()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.axQ().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.axQ().getTid(), 0L));
                        y.this.hbj.a(com.baidu.adp.lib.f.b.toLong(lVar.axQ().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.btK(), lVar.btL(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.axQ().getBaijiahaoData());
                    }
                    y.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bNs();
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
        al bVar;
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
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
        bVar.setPageUniqueId(this.dxg);
        bVar.setFrom("index");
        aVar.c(bVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Nj);
        kVar.setForm("index");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 1;
        dVar.cJy = 2;
        dVar.cJD = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aV(2);
        aVar.b(agVar);
        ad mT = aVar.mT();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(mT);
        aVar2.setPageId(this.dxg);
        mT.a(this.JE);
        mT.aM(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.y.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (y.this.JE != null) {
                        y.this.JE.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    afVar.mU().b(new a.C0050a(1));
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
        lVar.rm(lVar.position + 1);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.btA().c(lVar.btV());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.mU() != null) {
            aVar.mU().setPage(this.Lg);
        }
        com.baidu.card.w ad = aVar.ad(true);
        ad.a(this.dQj);
        ad.A(lVar.axS());
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQj = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hbj = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void onDestroy() {
        if (this.hbE != null) {
            this.hbE.onDestroy();
        }
    }

    public void onPause() {
        if (this.hbE != null) {
            this.hbE.onPause();
        }
    }

    public void onResume() {
        if (this.hbE != null) {
            this.hbE.onResume();
        }
    }
}
