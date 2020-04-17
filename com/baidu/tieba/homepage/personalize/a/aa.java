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
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> acX;
    private String aey;
    private boolean agt;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    private com.baidu.tieba.homepage.personalize.model.e hOB;
    private com.baidu.tieba.card.k hOV;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.ag(lVar.dqA));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.bFu());
            i = 0;
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.ag(lVar.dqA));
            TiebaStatic.log(lVar.bFz());
            i = 4;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.ah(lVar.dqA));
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.ah(lVar.dqA));
            i = 2;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.ag(lVar.dqA));
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
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.dqA, this.ebv, lVar.bFh(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euS = null;
        this.acX = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bEY().jd(true);
                com.baidu.tieba.a.d.bfP().cF("page_recommend", "show_");
                if (aa.this.hOB != null && lVar != null && lVar.aIw() != null && !StringUtils.isNull(lVar.aIw().getTid())) {
                    if (lVar.aIw().dtm > 0) {
                        TiebaStatic.log(lVar.ag(lVar.aIw()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.el(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L));
                        aa.this.hOB.a(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bFh(), lVar.bFi(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aIw().getBaijiahaoData());
                    }
                    aa.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZM();
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
        al dVar;
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebv);
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
        dVar.setPageUniqueId(this.ebv);
        dVar.setFrom("index");
        aVar.c(dVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.agt);
        kVar.setForm("index");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.dmT = 1;
        dVar2.dmU = 2;
        dVar2.dmZ = 1;
        agVar.setAgreeStatisticData(dVar2);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.bl(2);
        aVar.b(agVar);
        com.baidu.card.ad rC = aVar.rC();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(rC);
        aVar2.setPageId(this.ebv);
        rC.a(this.acX);
        rC.bc(2);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.aa.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (aa.this.acX != null) {
                        aa.this.acX.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    afVar.rD().b(new a.C0074a(1));
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
        com.baidu.tieba.card.r.bEY().e(lVar.bFs());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.rD() != null) {
            aVar.rD().setPage(this.aey);
        }
        com.baidu.card.w aF = aVar.aF(true);
        aF.a(this.euS);
        aF.A(lVar.aIy());
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euS = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hOB = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    public void onDestroy() {
        if (this.hOV != null) {
            this.hOV.onDestroy();
        }
    }

    public void onPause() {
        if (this.hOV != null) {
            this.hOV.onPause();
        }
    }

    public void onResume() {
        if (this.hOV != null) {
            this.hOV.onResume();
        }
    }
}
