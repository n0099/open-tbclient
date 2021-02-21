package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class aa extends com.baidu.tieba.frs.k<ca, ThreadCardViewHolder<cb>> implements com.baidu.adp.widget.ListView.w, com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private com.baidu.tieba.card.ab<cb> hnd;
    private int jqD;
    private String mFrom;

    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jqD = 3;
        this.hnd = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (aa.this.jga != null) {
                        aa.this.jga.a(view, (View) cbVar, (Object) aa.this.getType());
                    }
                    if ("c13010".equals(aa.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 1).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    com.baidu.tieba.frs.b.a.a(cbVar, 1, aa.this.mPageId, com.baidu.tieba.frs.b.d.jqE, aa.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && cbVar.bmv()) {
                        aa.this.as(cbVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.m.IN(cbVar.getTid());
                        if (cbVar.boE() != null) {
                            TiebaStatic.log(new ar("c13274").v("uid", TbadkCoreApplication.getCurrentAccountId()).v("fid", cbVar.getFid()).dR("obj_source", "frs_card").v("obj_id", cbVar.boE().swan_app_id.longValue()).dR("obj_name", cbVar.boE().name).dR("tid", cbVar.getTid()).ap("obj_param1", cbVar.boE().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.iLY);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.w) this);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) threadCardViewHolder);
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tj().setPage(this.aif);
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hnd);
        caVar.eJQ.bpd();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqD = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jqE;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            cb cbVar = ((ca) nVar).eJQ;
            cbVar.objType = 1;
            if (this.hnd != null) {
                this.hnd.a(threadCardViewHolder.getView(), cbVar);
            }
            az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), this.jqD, false);
            threadCardViewHolder.tj().b(new a.C0089a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(cb cbVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).ap("obj_locate", cCn() ? 2 : 1).v("obj_id", cbVar.boj() == null ? -1L : cbVar.boj().live_id).ap("obj_type", 1));
    }
}
