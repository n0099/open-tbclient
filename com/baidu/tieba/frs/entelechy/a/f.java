package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String YA;
    private boolean bSN;
    private ab<bg> dqg;
    private boolean fhc;
    private int fhd;
    private String mFrom;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fhc = false;
        this.bSN = false;
        this.fhd = 3;
        this.dqg = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (f.this.eYB != null) {
                        f.this.eYB.a(view, (View) bgVar, (Object) f.this.getType());
                    }
                    if ("c13010".equals(f.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 1).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.thread_card_root && bgVar.ZL()) {
                        f.this.af(bgVar);
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bil().a(com.baidu.tieba.frs.d.d.fhe, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, f.this.mPageId, com.baidu.tieba.frs.d.d.fhe);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fhe, bgVar.WS());
                    } else if (view instanceof TbImageView) {
                        if (f.this.dqg.Zw instanceof Boolean) {
                            if (((Boolean) f.this.dqg.Zw).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bil().a(com.baidu.tieba.frs.d.d.fhe, bgVar, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar, 1, f.this.mPageId, com.baidu.tieba.frs.d.d.fhe);
                            } else {
                                com.baidu.tieba.frs.d.c.bil().a(com.baidu.tieba.frs.d.d.fhe, bgVar, 3);
                                com.baidu.tieba.frs.d.a.a(bgVar, 3, f.this.mPageId, com.baidu.tieba.frs.d.d.fhe);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    } else if (view.getId() == d.g.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bil().a(com.baidu.tieba.frs.d.d.fhe, bgVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bgVar.aap() != null && bgVar.aap().cev() != null && bgVar.aap().cev().asw() != null && bgVar.aap().cev().asw().size() > 0) {
                            i = bgVar.aap().iGH ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bil().a(com.baidu.tieba.frs.d.d.fhe, bgVar, i);
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, f.this.mPageId, com.baidu.tieba.frs.d.d.fhe);
                    } else {
                        com.baidu.tieba.frs.d.c.bil().a(com.baidu.tieba.frs.d.d.fhe, bgVar, 1);
                    }
                    com.baidu.tieba.frs.d.a.a(bgVar, 5, f.this.mPageId, com.baidu.tieba.frs.d.d.fhe);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public com.baidu.card.z<bg> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxj = this.fhc ? 10 : 2;
        dVar.bxo = 2;
        aaVar.setAgreeStatisticData(dVar);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bA(3);
        aaVar.bu(16);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.C0277d.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(true, viewGroup, this.eEr);
        a.by(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.aI(true);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.f.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (f.this.dqg != null) {
                        f.this.dqg.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), f.this.fhd, false);
                    zVar2.rx().b(new a.C0039a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, com.baidu.card.z<bg> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bfVar, zVar);
        if (bfVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.rx().setPage(this.YA);
        zVar.rx().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.rx().rr(), this.eYv);
        if (this.eYv != null && this.eYv.getForum() != null && !StringUtils.isNull(this.eYv.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYv.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bt(this.eYv.getForum().getTopic_special_icon(), this.eYv.getForum().getTopic_special_icon_right());
        }
        zVar.a(bfVar.threadData);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.dqg);
        bfVar.threadData.ZV();
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.fhd = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void hS(boolean z) {
        this.fhc = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfz() {
        return fhe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bg bgVar) {
        TiebaStatic.log(new am("c12126").bJ("tid", bgVar.getId()).T("obj_locate", bcj() ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zk() == null ? -1L : bgVar.Zk().live_id).T("obj_type", 1));
    }
}
