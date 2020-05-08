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
public class aa extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> ada;
    private String aeB;
    private boolean agw;
    public BdUniqueId ebA;
    private NEGFeedBackView.a euX;
    private com.baidu.tieba.homepage.personalize.model.e hOH;
    private com.baidu.tieba.card.k hPb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.ag(lVar.dqE));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.bFs());
            i = 0;
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.ag(lVar.dqE));
            TiebaStatic.log(lVar.bFx());
            i = 4;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.ah(lVar.dqE));
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.ah(lVar.dqE));
            i = 2;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.ag(lVar.dqE));
            i = 5;
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.af("obj_locate", 4);
            TiebaStatic.log(anVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.af("obj_locate", 2);
            TiebaStatic.log(anVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.af("obj_locate", 1);
            TiebaStatic.log(anVar3);
            i = 0;
        } else {
            if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                an anVar4 = new an("c10760");
                anVar4.af("obj_locate", 3);
                TiebaStatic.log(anVar4);
            }
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.dqE, this.ebA, lVar.bFf(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euX = null;
        this.ada = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bEW().jd(true);
                com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
                if (aa.this.hOH != null && lVar != null && lVar.aIu() != null && !StringUtils.isNull(lVar.aIu().getTid())) {
                    if (lVar.aIu().dtq > 0) {
                        TiebaStatic.log(lVar.ag(lVar.aIu()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(lVar.aIu().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.el(com.baidu.adp.lib.f.b.toLong(lVar.aIu().getTid(), 0L));
                        aa.this.hOH.a(com.baidu.adp.lib.f.b.toLong(lVar.aIu().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bFf(), lVar.bFg(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aIu().getBaijiahaoData());
                    }
                    aa.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZK();
    }

    private void bZK() {
        com.baidu.tieba.card.data.l.gsA = "c10708";
        com.baidu.tieba.card.data.l.gsB = "c10735";
        com.baidu.tieba.card.data.l.gsY = "c10709";
        com.baidu.tieba.card.data.l.gsz = "c10734";
        com.baidu.tieba.card.data.l.gsZ = "c11929";
        com.baidu.tieba.card.data.l.gta = "c11928";
        com.baidu.tieba.card.data.l.gtb = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        al dVar;
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebA);
        eVar.aX(1024);
        aVar.a(eVar);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            dVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
            dVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar2) {
                    if (aVar2 != null) {
                        if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                            au.a(aVar2, aa.this.mContext, 2, false);
                            return;
                        }
                        aVar2.objType = 5;
                        au.a(aVar2, aa.this.mContext, 2, false);
                    }
                }
            });
        } else {
            dVar = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity());
        }
        dVar.setPageUniqueId(this.ebA);
        dVar.setFrom("index");
        aVar.c(dVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.agw);
        kVar.setForm("index");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.dmX = 1;
        dVar2.dmY = 2;
        dVar2.dnd = 1;
        agVar.setAgreeStatisticData(dVar2);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.bl(2);
        aVar.b(agVar);
        com.baidu.card.ad rC = aVar.rC();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(rC);
        aVar2.setPageId(this.ebA);
        rC.a(this.ada);
        rC.bc(2);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.aa.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (aa.this.ada != null) {
                        aa.this.ada.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    afVar.rD().b(new a.C0095a(1));
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
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bEW().e(lVar.bFq());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.rD() != null) {
            aVar.rD().setPage(this.aeB);
        }
        com.baidu.card.w aF = aVar.aF(true);
        aF.a(this.euX);
        aF.B(lVar.aIw());
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.ada);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dqE, this.ebA, lVar.bFf());
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "1";
            yVar.ahO = lVar.tid;
            if (lVar.aIu() != null) {
                yVar.eQk = String.valueOf(lVar.aIu().getFid());
                if (lVar.aIu().aKT() != null) {
                    yVar.kiw = lVar.aIu().aKT().video_md5;
                    yVar.kiy = String.valueOf(lVar.aIu().aKT().is_vertical);
                }
            }
            yVar.dop = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kiv = lVar.bFg();
            yVar.kis = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bFf());
            if (lVar.aIu() != null && lVar.aIu().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aIu().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aIu().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euX = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hOH = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    public void onDestroy() {
        if (this.hPb != null) {
            this.hPb.onDestroy();
        }
    }

    public void onPause() {
        if (this.hPb != null) {
            this.hPb.onPause();
        }
    }

    public void onResume() {
        if (this.hPb != null) {
            this.hPb.onResume();
        }
    }
}
