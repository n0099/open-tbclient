package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class q extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String YA;
    private boolean bSP;
    private NEGFeedBackView.a dqL;
    private ab<bg> dqj;
    private boolean fgO;
    private int fgP;
    private String mFrom;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fgO = false;
        this.bSP = false;
        this.fgP = 3;
        this.dqj = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (q.this.eYn != null) {
                        q.this.eYn.a(view, (View) bgVar, (Object) q.this.getType());
                    }
                    if ("c13010".equals(q.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 1).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.thread_card_root && bgVar.ZI()) {
                        q.this.ae(bgVar);
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, q.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fgQ, bgVar.WP());
                    } else if (view instanceof TbImageView) {
                        if (q.this.dqj.Zw instanceof Boolean) {
                            if (((Boolean) q.this.dqj.Zw).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar, 1, q.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 3);
                            com.baidu.tieba.frs.d.a.a(bgVar, 3, q.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    } else if (view.getId() == d.g.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bgVar.aam() != null && bgVar.aam().cer() != null && bgVar.aam().cer().ast() != null && bgVar.aam().cer().ast().size() > 0) {
                            i = bgVar.aam().iGr ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, i);
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, q.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                    } else {
                        com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, q.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                    }
                }
            }
        };
        this.dqL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.q.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new am("c11973").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11974").bJ("obj_locate", sb.toString()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public void setInFrsAllThread(boolean z) {
        this.bSP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public com.baidu.card.z<bg> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bt(184);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.q.3
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == d.g.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == d.g.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        aVar.rv().setBackgroundResource(d.C0277d.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eEc);
        a.bx(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.aI(false);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.q.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (q.this.dqj != null) {
                        q.this.dqj.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), q.this.fgP, false);
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
        com.baidu.tieba.frs.g.a(zVar.rx().rr(), this.eYh);
        if (this.eYh != null && this.eYh.getForum() != null && !StringUtils.isNull(this.eYh.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYh.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bt(this.eYh.getForum().getTopic_special_icon(), this.eYh.getForum().getTopic_special_icon_right());
        }
        boolean z = (bfVar.threadData.YO() == null || bfVar.threadData.YO().getUserId() == null || !bfVar.threadData.YO().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bfVar.threadData.ZX() && bfVar.threadData.Xx() != null && !z) {
            zVar.ry().a(this.dqL);
        }
        zVar.rA();
        zVar.a(bfVar.threadData);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.dqj);
        bfVar.threadData.ZS();
        if (fgQ != null) {
            bfVar.threadData.bDU = (bfVar.position + 1) - (this.eYh != null ? this.eYh.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bij().a(fgQ, bfVar.threadData);
        bfVar.threadData.ZS();
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, fgQ);
        if (bfVar != null) {
            bfVar.threadData.ZS();
        }
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mC(int i) {
        this.fgP = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void hS(boolean z) {
        this.fgO = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfx() {
        return fgQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new am("c12126").bJ("tid", bgVar.getId()).T("obj_locate", bch() ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zh() == null ? -1L : bgVar.Zh().live_id).T("obj_type", 1));
    }
}
