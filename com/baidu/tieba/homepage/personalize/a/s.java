package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.ac;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> Xs;
    private String YB;
    private boolean ZR;
    private NEGFeedBackView.a cIW;
    public BdUniqueId coa;
    private com.baidu.tieba.homepage.personalize.model.e fLD;
    private com.baidu.tieba.card.m fLV;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int id = view.getId();
        if (id == d.g.thread_card_root) {
            TiebaStatic.log(lVar.X(lVar.cZD));
            com.baidu.tieba.q.c.cdp().b(this.coa, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_click", 1, lVar.aQN(), false, null, null));
        } else if (id == d.g.forum_name_text) {
            TiebaStatic.log(lVar.aRa());
        } else if (id == d.g.operable_video_container) {
            TiebaStatic.log(lVar.X(lVar.cZD));
            com.baidu.tieba.q.c.cdp().b(this.coa, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_click", 4, lVar.aQN(), false, null, null));
            TiebaStatic.log(lVar.aRf());
        } else if (id == d.g.user_avatar) {
            TiebaStatic.log(lVar.Y(lVar.cZD));
            com.baidu.tieba.q.c.cdp().b(this.coa, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_click", 2, lVar.aQN(), false, null, null));
        } else if (id == d.g.user_name) {
            TiebaStatic.log(lVar.Y(lVar.cZD));
            com.baidu.tieba.q.c.cdp().b(this.coa, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_click", 2, lVar.aQN(), false, null, null));
        } else if (id == d.g.thread_info_commont_container) {
            TiebaStatic.log(lVar.X(lVar.cZD));
            com.baidu.tieba.q.c.cdp().b(this.coa, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_click", 5, lVar.aQN(), false, null, null));
        } else if (id == d.g.god_reply_voice_btn) {
            am amVar = new am("c10760");
            amVar.T("obj_locate", 4);
            TiebaStatic.log(amVar);
        } else if (id == d.g.god_reply_content) {
            am amVar2 = new am("c10760");
            amVar2.T("obj_locate", 2);
            TiebaStatic.log(amVar2);
        } else if (id == d.g.god_reply_user_pendant_header || id == d.g.god_reply_username_text) {
            am amVar3 = new am("c10760");
            amVar3.T("obj_locate", 1);
            TiebaStatic.log(amVar3);
        } else if ((view instanceof TbImageView) && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            am amVar4 = new am("c10760");
            amVar4.T("obj_locate", 3);
            TiebaStatic.log(amVar4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIW = null;
        this.Xs = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.aQD().go(true);
                com.baidu.tieba.a.d.awh().bA("page_recommend", "show_");
                if (s.this.fLD != null && lVar != null && lVar.WO() != null && !StringUtils.isNull(lVar.WO().getTid())) {
                    if (lVar.WO().bDx > 0) {
                        TiebaStatic.log(lVar.X(lVar.WO()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cM(com.baidu.adp.lib.g.b.d(lVar.WO().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cL(com.baidu.adp.lib.g.b.d(lVar.WO().getTid(), 0L));
                        s.this.fLD.a(com.baidu.adp.lib.g.b.d(lVar.WO().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aQN(), lVar.aQO(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    s.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmI();
    }

    private void bmI() {
        com.baidu.tieba.card.data.l.elf = "c10708";
        com.baidu.tieba.card.data.l.ely = "c10735";
        com.baidu.tieba.card.data.l.elz = "c10709";
        com.baidu.tieba.card.data.l.ele = "c10734";
        com.baidu.tieba.card.data.l.elA = "c11929";
        com.baidu.tieba.card.data.l.elB = "c11928";
        com.baidu.tieba.card.data.l.elC = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        ac bVar;
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.coa);
        dVar.bu(1024);
        aVar.c(dVar);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            bVar = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        bVar.setPageUniqueId(this.coa);
        bVar.setFrom("index");
        aVar.b(bVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZR);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bxn = 1;
        dVar2.bxo = 2;
        dVar2.bxs = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bz(2);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        x rw = aVar.rw();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(rw);
        aVar2.setPageId(this.coa);
        rw.a(this.Xs);
        rw.bx(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (s.this.Xs != null) {
                        s.this.Xs.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    zVar.rx().b(new a.C0039a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar != null) {
            lVar.oo(lVar.position + 1);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.aQD().b(lVar.aQY());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.elx) {
                am amVar = new am("c11003");
                bg WO = lVar.WO();
                if (WO != null) {
                    amVar.bJ("tid", WO.getTid());
                    if (WO.YO() != null) {
                        amVar.T("ab_type", WO.YO().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.aQD().b(amVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.rx() != null) {
                aVar.rx().setPage(this.YB);
            }
            com.baidu.card.s ry = aVar.ry();
            ry.a(this.cIW);
            ry.C(lVar.WQ());
            aVar.a(lVar);
            aVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.rx().a(this.Xs);
            com.baidu.tieba.q.c.cdp().a(this.coa, lVar.cZD != null ? lVar.cZD.getId() : null, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_exp", lVar.aQN(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.ctx = lVar.tid;
            if (lVar.WO() != null) {
                zVar.ekN = String.valueOf(lVar.WO().getFid());
                if (lVar.WO().Zf() != null) {
                    zVar.hYC = lVar.WO().Zf().video_md5;
                    zVar.hYE = String.valueOf(lVar.WO().Zf().is_vertical);
                }
            }
            zVar.byE = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.hYB = lVar.aQO();
            zVar.hYz = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aQN());
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIW = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fLD = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YB = str;
    }

    public void setFromCDN(boolean z) {
        this.ZR = z;
    }

    public void onDestroy() {
        if (this.fLV != null) {
            this.fLV.onDestroy();
        }
    }

    public void onPause() {
        if (this.fLV != null) {
            this.fLV.onPause();
        }
    }

    public void onResume() {
        if (this.fLV != null) {
            this.fLV.onResume();
        }
    }
}
