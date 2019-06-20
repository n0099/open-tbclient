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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> Vi;
    private String Ws;
    private boolean XI;
    private NEGFeedBackView.a cRh;
    public BdUniqueId cwi;
    private com.baidu.tieba.homepage.personalize.model.e gcO;
    private com.baidu.tieba.card.m gdf;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.X(lVar.threadData));
            com.baidu.tieba.q.c.clw().b(this.cwi, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 1, lVar.aXZ(), false, (String) null, (String) null));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.aYm());
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.X(lVar.threadData));
            com.baidu.tieba.q.c.clw().b(this.cwi, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 4, lVar.aXZ(), false, (String) null, (String) null));
            TiebaStatic.log(lVar.aYr());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.Y(lVar.threadData));
            com.baidu.tieba.q.c.clw().b(this.cwi, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 2, lVar.aXZ(), false, (String) null, (String) null));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.Y(lVar.threadData));
            com.baidu.tieba.q.c.clw().b(this.cwi, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 2, lVar.aXZ(), false, (String) null, (String) null));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.X(lVar.threadData));
            com.baidu.tieba.q.c.clw().b(this.cwi, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 5, lVar.aXZ(), false, (String) null, (String) null));
        } else if (id == R.id.god_reply_voice_btn) {
            am amVar = new am("c10760");
            amVar.P("obj_locate", 4);
            TiebaStatic.log(amVar);
        } else if (id == R.id.god_reply_content) {
            am amVar2 = new am("c10760");
            amVar2.P("obj_locate", 2);
            TiebaStatic.log(amVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            am amVar3 = new am("c10760");
            amVar3.P("obj_locate", 1);
            TiebaStatic.log(amVar3);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            am amVar4 = new am("c10760");
            amVar4.P("obj_locate", 3);
            TiebaStatic.log(amVar4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRh = null;
        this.Vi = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.aXP().gM(true);
                com.baidu.tieba.a.d.aBq().bJ("page_recommend", "show_");
                if (t.this.gcO != null && lVar != null && lVar.abv() != null && !StringUtils.isNull(lVar.abv().getTid())) {
                    if (lVar.abv().bKO > 0) {
                        TiebaStatic.log(lVar.X(lVar.abv()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dj(com.baidu.adp.lib.g.b.c(lVar.abv().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.di(com.baidu.adp.lib.g.b.c(lVar.abv().getTid(), 0L));
                        t.this.gcO.a(com.baidu.adp.lib.g.b.c(lVar.abv().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aXZ(), lVar.aYa(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    t.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buo();
    }

    private void buo() {
        com.baidu.tieba.card.data.l.eAU = "c10708";
        com.baidu.tieba.card.data.l.eAV = "c10735";
        com.baidu.tieba.card.data.l.eBn = "c10709";
        com.baidu.tieba.card.data.l.eAT = "c10734";
        com.baidu.tieba.card.data.l.eBo = "c11929";
        com.baidu.tieba.card.data.l.eBp = "c11928";
        com.baidu.tieba.card.data.l.eBq = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        ac bVar;
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cwi);
        dVar.bn(1024);
        aVar.c(dVar);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            bVar = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        bVar.setPageUniqueId(this.cwi);
        bVar.setFrom("index");
        aVar.b(bVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XI);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEz = 1;
        dVar2.bEA = 2;
        dVar2.bEE = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        x qr = aVar.qr();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(qr);
        aVar2.setPageId(this.cwi);
        qr.a(this.Vi);
        qr.bq(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (t.this.Vi != null) {
                        t.this.Vi.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    zVar.qs().b(new a.C0038a(1));
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
            lVar.ps(lVar.position + 1);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.aXP().b(lVar.aYk());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.eBm) {
                am amVar = new am("c11003");
                bg abv = lVar.abv();
                if (abv != null) {
                    amVar.bT("tid", abv.getTid());
                    if (abv.adv() != null) {
                        amVar.P("ab_type", abv.adv().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.aXP().b(amVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.qs() != null) {
                aVar.qs().setPage(this.Ws);
            }
            com.baidu.card.s qt = aVar.qt();
            qt.a(this.cRh);
            qt.C(lVar.abx());
            aVar.a(lVar);
            aVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qs().a(this.Vi);
            com.baidu.tieba.q.c.clw().a(this.cwi, lVar.threadData != null ? lVar.threadData.getId() : null, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_exp", lVar.aXZ(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.bVM = lVar.tid;
            if (lVar.abv() != null) {
                zVar.eAC = String.valueOf(lVar.abv().getFid());
                if (lVar.abv().adM() != null) {
                    zVar.irm = lVar.abv().adM().video_md5;
                    zVar.iro = String.valueOf(lVar.abv().adM().is_vertical);
                }
            }
            zVar.bFQ = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.irl = lVar.aYa();
            zVar.irj = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aXZ());
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cRh = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gcO = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rU(String str) {
        this.Ws = str;
    }

    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    public void onDestroy() {
        if (this.gdf != null) {
            this.gdf.onDestroy();
        }
    }

    public void onPause() {
        if (this.gdf != null) {
            this.gdf.onPause();
        }
    }

    public void onResume() {
        if (this.gdf != null) {
            this.gdf.onResume();
        }
    }
}
