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
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.l> JZ;
    private String LC;
    private boolean NK;
    public BdUniqueId dBK;
    private NEGFeedBackView.a dUT;
    private com.baidu.tieba.homepage.personalize.model.e heO;
    private com.baidu.tieba.card.k hfj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.ag(lVar.cRt));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.bvJ());
            i = 0;
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.ag(lVar.cRt));
            TiebaStatic.log(lVar.bvO());
            i = 4;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.ah(lVar.cRt));
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.ah(lVar.cRt));
            i = 2;
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.ag(lVar.cRt));
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
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.cRt, this.dBK, lVar.bvw(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUT = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.bvm().id(true);
                com.baidu.tieba.a.d.aXK().cu("page_recommend", "show_");
                if (aa.this.heO != null && lVar != null && lVar.aAj() != null && !StringUtils.isNull(lVar.aAj().getTid())) {
                    if (lVar.aAj().cUc > 0) {
                        TiebaStatic.log(lVar.ag(lVar.aAj()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L));
                        aa.this.heO.a(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bvw(), lVar.bvx(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.aAj().getBaijiahaoData());
                    }
                    aa.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bPl();
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
        al dVar;
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBK);
        eVar.aL(1024);
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
        dVar.setPageUniqueId(this.dBK);
        dVar.setFrom("index");
        aVar.c(dVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NK);
        kVar.setForm("index");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.cNP = 1;
        dVar2.cNQ = 2;
        dVar2.cNV = 1;
        agVar.setAgreeStatisticData(dVar2);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        aVar.b(agVar);
        com.baidu.card.ad nj = aVar.nj();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(nj);
        aVar2.setPageId(this.dBK);
        nj.a(this.JZ);
        nj.aQ(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.aa.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (aa.this.JZ != null) {
                        aa.this.JZ.a(afVar.getView(), lVar);
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
        lVar.rv(lVar.position + 1);
        lVar.sourceType = 0;
        com.baidu.tieba.card.r.bvm().e(lVar.bvH());
        aVar.setVideoStatsData(c(lVar));
        if (aVar.nk() != null) {
            aVar.nk().setPage(this.LC);
        }
        com.baidu.card.w ag = aVar.ag(true);
        ag.a(this.dUT);
        ag.A(lVar.aAl());
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUT = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.heO = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    public void onDestroy() {
        if (this.hfj != null) {
            this.hfj.onDestroy();
        }
    }

    public void onPause() {
        if (this.hfj != null) {
            this.hfj.onPause();
        }
    }

    public void onResume() {
        if (this.hfj != null) {
            this.hfj.onResume();
        }
    }
}
