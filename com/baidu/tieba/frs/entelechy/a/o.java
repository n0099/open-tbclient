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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class o extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean Yd;
    private boolean cbL;
    private ab<bg> dEm;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cbL = false;
        this.Yd = true;
        this.dEm = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (o.this.fty != null) {
                        o.this.fty.a(view, (View) bgVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brF().a(com.baidu.tieba.frs.d.d.fCh, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.fCh);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fCh, bgVar.acy());
                    } else if (view instanceof TbImageView) {
                        if (o.this.dEm.XJ instanceof Boolean) {
                            if (((Boolean) o.this.dEm.XJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.brF().a(com.baidu.tieba.frs.d.d.fCh, bgVar, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.fCh);
                            } else {
                                com.baidu.tieba.frs.d.c.brF().a(com.baidu.tieba.frs.d.d.fCh, bgVar, 3);
                                com.baidu.tieba.frs.d.a.a(bgVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.fCh);
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.fCh);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.brF().a(com.baidu.tieba.frs.d.d.fCh, bgVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bgVar.afV() != null && bgVar.afV().cpr() != null && bgVar.afV().cpr().ayL() != null && bgVar.afV().cpr().ayL().size() > 0) {
                            i = bgVar.afV().jfE ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.brF().a(com.baidu.tieba.frs.d.d.fCh, bgVar, i);
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.fCh);
                    } else {
                        com.baidu.tieba.frs.d.c.brF().a(com.baidu.tieba.frs.d.d.fCh, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.fCh);
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
    public com.baidu.card.z<bg> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.setFrom("frs");
        qVar.setFromCDN(this.Yd);
        aVar.b(qVar);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eYZ);
        a.bq(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.aD(false);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (o.this.dEm != null) {
                        o.this.dEm.a(zVar2.getView(), bgVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), 3, false);
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
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, com.baidu.card.z<bg> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bfVar, zVar);
        if (bfVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.qP().setPage(this.WN);
        zVar.qP().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.qP().qJ(), this.fts);
        if (this.fts != null && this.fts.getForum() != null && !StringUtils.isNull(this.fts.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fts.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bC(this.fts.getForum().getTopic_special_icon(), this.fts.getForum().getTopic_special_icon_right());
        }
        zVar.a(bfVar.threadData);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.dEm);
        bfVar.threadData.afB();
        com.baidu.card.q qVar = (com.baidu.card.q) zVar.qP().qI();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.Wp.YI.getLayoutParams();
        layoutParams.width = bfVar.bJg;
        layoutParams.height = bfVar.bJh;
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
    public void nC(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b boU() {
        return fCh;
    }
}
