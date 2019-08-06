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
public class o extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean Yd;
    private boolean cbS;
    private ab<bh> dEt;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cbS = false;
        this.Yd = true;
        this.dEt = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (o.this.ftX != null) {
                        o.this.ftX.a(view, (View) bhVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).l("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fCV, bhVar.acz());
                    } else if (view instanceof TbImageView) {
                        if (o.this.dEt.XJ instanceof Boolean) {
                            if (((Boolean) o.this.dEt.XJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                            } else {
                                com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 3);
                                com.baidu.tieba.frs.d.a.a(bhVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
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
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                    } else {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
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
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.setFrom("frs");
        qVar.setFromCDN(this.Yd);
        aVar.b(qVar);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eZn);
        a.bq(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.aD(false);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).threadData;
                    bhVar.objType = 1;
                    if (o.this.dEt != null) {
                        o.this.dEt.a(zVar2.getView(), bhVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), 3, false);
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
        com.baidu.card.q qVar = (com.baidu.card.q) zVar.qP().qI();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.Wp.YI.getLayoutParams();
        layoutParams.width = bgVar.bJl;
        layoutParams.height = bgVar.bJm;
        if (qVar.Wp.YI.getVisibility() != 8) {
            qVar.Wp.YI.setLayoutParams(layoutParams);
        }
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
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return fCV;
    }
}
