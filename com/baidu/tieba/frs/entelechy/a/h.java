package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class h extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean Yd;
    private boolean cbS;
    private ab<bh> dEt;
    private boolean fCS;
    private int fCU;
    private String mFrom;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fCS = false;
        this.cbS = false;
        this.Yd = true;
        this.fCU = 3;
        this.dEt = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (h.this.ftX != null) {
                        h.this.ftX.a(view, (View) bhVar, (Object) h.this.getType());
                    }
                    if ("c13010".equals(h.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).l("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.afs()) {
                        h.this.af(bhVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, h.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fCV, bhVar.acz());
                    } else if (view instanceof TbImageView) {
                        if (h.this.dEt.XJ instanceof Boolean) {
                            if (((Boolean) h.this.dEt.XJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, h.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 3);
                            com.baidu.tieba.frs.d.a.a(bhVar, 3, h.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bhVar.afW() != null && bhVar.afW().cpN() != null && bhVar.afW().cpN().ayN() != null && bhVar.afW().cpN().ayN().size() > 0) {
                            i = bhVar.afW().jgL ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, i);
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, h.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                    } else {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, h.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
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
    /* renamed from: aL */
    public com.baidu.card.z<bh> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.f) hVar);
        hVar.setFromCDN(this.Yd);
        hVar.setForm("frs");
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eZn);
        a.bq(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.h.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).threadData;
                    bhVar.objType = 1;
                    if (h.this.dEt != null) {
                        h.this.dEt.a(zVar2.getView(), bhVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), h.this.fCU, false);
                    zVar2.qP().b(new a.C0038a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bh> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bgVar, zVar);
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.qP().setPage(this.WN);
        zVar.qP().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.qP().qJ(), this.ftR);
        if (this.ftR != null && this.ftR.getForum() != null && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon_right())) {
            bgVar.threadData.bC(this.ftR.getForum().getTopic_special_icon(), this.ftR.getForum().getTopic_special_icon_right());
        }
        zVar.a(bgVar.threadData);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.dEt);
        bgVar.threadData.afC();
        return zVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nD(int i) {
        this.fCU = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void iG(boolean z) {
        this.fCS = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return fCV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", blN() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bhVar.aeR() == null ? -1L : bhVar.aeR().live_id).P("obj_type", 1));
    }
}
