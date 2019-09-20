package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class p extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.adp.widget.ListView.s, com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WM;
    private ab<bh> dGe;
    private int fEH;
    private String mFrom;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fEH = 3;
        this.dGe = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (p.this.fvK != null) {
                        p.this.fvK.a(view, (View) bhVar, (Object) p.this.getType());
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).n("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.afw()) {
                        p.this.ag(bhVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.n.vW(bhVar.getTid());
                        if (bhVar.afo() != null) {
                            TiebaStatic.log(new an("c13274").n("uid", TbadkCoreApplication.getCurrentAccountId()).n("fid", bhVar.getFid()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_card").n(VideoPlayActivityConfig.OBJ_ID, bhVar.afo().swan_app_id.longValue()).bT("obj_name", bhVar.afo().name).bT("tid", bhVar.getTid()).P("obj_param1", bhVar.afo().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.bsF().a(com.baidu.tieba.frs.d.d.fEI, bhVar, 1);
                    com.baidu.tieba.frs.d.a.a(bhVar, 1, p.this.mPageId, com.baidu.tieba.frs.d.d.fEI);
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
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        com.baidu.card.x a = aVar.a(false, viewGroup, this.faT);
        a.bq(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(this);
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
        zVar.qQ().setPage(this.WM);
        zVar.qQ().setPosition(i);
        zVar.a(bgVar.threadData);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.dGe);
        bgVar.threadData.afG();
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nH(int i) {
        this.fEH = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void iJ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return fEI;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
            com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
            bh bhVar = ((bg) mVar).threadData;
            bhVar.objType = 1;
            if (this.dGe != null) {
                this.dGe.a(zVar.getView(), bhVar);
            }
            au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), this.fEH, false);
            zVar.qQ().b(new a.C0038a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", bmy() ? 2 : 1).n(VideoPlayActivityConfig.OBJ_ID, bhVar.aeV() == null ? -1L : bhVar.aeV().live_id).P("obj_type", 1));
    }
}
