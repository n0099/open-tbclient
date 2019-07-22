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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class p extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.adp.widget.ListView.s, com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private ab<bg> dEm;
    private int fCg;
    private String mFrom;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fCg = 3;
        this.dEm = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (p.this.fty != null) {
                        p.this.fty.a(view, (View) bgVar, (Object) p.this.getType());
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bgVar.afr()) {
                        p.this.ae(bgVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.n.vw(bgVar.getTid());
                        if (bgVar.afj() != null) {
                            TiebaStatic.log(new an("c13274").l("uid", TbadkCoreApplication.getCurrentAccountId()).l("fid", bgVar.getFid()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_card").l(VideoPlayActivityConfig.OBJ_ID, bgVar.afj().swan_app_id.longValue()).bT("obj_name", bgVar.afj().name).bT("tid", bgVar.getTid()).P("obj_param1", bgVar.afj().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.brF().a(com.baidu.tieba.frs.d.d.fCh, bgVar, 1);
                    com.baidu.tieba.frs.d.a.a(bgVar, 1, p.this.mPageId, com.baidu.tieba.frs.d.d.fCh);
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
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eYZ);
        a.bq(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(this);
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
        zVar.a(bfVar.threadData);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.dEm);
        bfVar.threadData.afB();
        return zVar.getView();
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
        this.fCg = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void iG(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b boU() {
        return fCh;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
            com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
            bg bgVar = ((bf) mVar).threadData;
            bgVar.objType = 1;
            if (this.dEm != null) {
                this.dEm.a(zVar.getView(), bgVar);
            }
            av.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), this.fCg, false);
            zVar.qP().b(new a.C0038a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bgVar.getId()).P("obj_locate", blG() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.aeQ() == null ? -1L : bgVar.aeQ().live_id).P("obj_type", 1));
    }
}
