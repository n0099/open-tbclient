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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class p extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.adp.widget.ListView.s, com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Wt;
    private ab<bg> dAQ;
    private int fxk;
    private String mFrom;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fxk = 3;
        this.dAQ = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (p.this.foz != null) {
                        p.this.foz.a(view, (View) bgVar, (Object) p.this.getType());
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").P("obj_type", 1).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bgVar.aep()) {
                        p.this.ae(bgVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.n.uS(bgVar.getTid());
                        if (bgVar.aeh() != null) {
                            TiebaStatic.log(new am("c13274").l("uid", TbadkCoreApplication.getCurrentAccountId()).l("fid", bgVar.getFid()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_card").l(VideoPlayActivityConfig.OBJ_ID, bgVar.aeh().swan_app_id.longValue()).bT("obj_name", bgVar.aeh().name).bT("tid", bgVar.getTid()).P("obj_param1", bgVar.aeh().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.bpC().a(com.baidu.tieba.frs.d.d.fxl, bgVar, 1);
                    com.baidu.tieba.frs.d.a.a(bgVar, 1, p.this.mPageId, com.baidu.tieba.frs.d.d.fxl);
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
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        aVar.qq().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eTY);
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
        zVar.qs().setPage(this.Wt);
        zVar.qs().setPosition(i);
        zVar.a(bfVar.threadData);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.dAQ);
        bfVar.threadData.aez();
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxk = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void ix(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmT() {
        return fxl;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
            com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
            bg bgVar = ((bf) mVar).threadData;
            bgVar.objType = 1;
            if (this.dAQ != null) {
                this.dAQ.a(zVar.getView(), bgVar);
            }
            au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), this.fxk, false);
            zVar.qs().b(new a.C0038a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new am("c12126").bT("tid", bgVar.getId()).P("obj_locate", bjE() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.adO() == null ? -1L : bgVar.adO().live_id).P("obj_type", 1));
    }
}
