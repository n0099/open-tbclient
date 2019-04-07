package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class o extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String YA;
    private boolean ZQ;
    private boolean bSP;
    private ab<bg> dqj;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bSP = false;
        this.ZQ = true;
        this.dqj = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (o.this.eYn != null) {
                        o.this.eYn.a(view, (View) bgVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 1).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fgQ, bgVar.WP());
                    } else if (view instanceof TbImageView) {
                        if (o.this.dqj.Zw instanceof Boolean) {
                            if (((Boolean) o.this.dqj.Zw).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                            } else {
                                com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 3);
                                com.baidu.tieba.frs.d.a.a(bgVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
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
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                    } else {
                        com.baidu.tieba.frs.d.c.bij().a(com.baidu.tieba.frs.d.d.fgQ, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.fgQ);
                    }
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
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.setFrom("frs");
        qVar.setFromCDN(this.ZQ);
        aVar.b(qVar);
        aVar.rv().setBackgroundResource(d.C0277d.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eEc);
        a.bx(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.aI(false);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (o.this.dqj != null) {
                        o.this.dqj.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), 3, false);
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
        zVar.a(bfVar.threadData);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.dqj);
        bfVar.threadData.ZS();
        com.baidu.card.q qVar = (com.baidu.card.q) zVar.rx().rq();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.Yd.aav.getLayoutParams();
        layoutParams.width = bfVar.bAQ;
        layoutParams.height = bfVar.bAR;
        if (qVar.Yd.aav.getVisibility() != 8) {
            qVar.Yd.aav.setLayoutParams(layoutParams);
        }
        return zVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.ZQ = z;
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
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfx() {
        return fgQ;
    }
}
