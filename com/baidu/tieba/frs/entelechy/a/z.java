package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class z extends com.baidu.tieba.frs.k<bx, com.baidu.card.am<by>> implements com.baidu.adp.widget.ListView.ab, com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private com.baidu.tieba.card.ab<by> hbw;
    private int jcT;
    private String mFrom;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jcT = 3;
        this.hbw = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (z.this.iSB != null) {
                        z.this.iSB.a(view, (View) byVar, (Object) z.this.getType());
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 1).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(byVar, 1, z.this.mPageId, com.baidu.tieba.frs.d.d.jcU, z.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && byVar.bnv()) {
                        z.this.as(byVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.n.Jq(byVar.getTid());
                        if (byVar.bpE() != null) {
                            TiebaStatic.log(new ar("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", byVar.getFid()).dY("obj_source", "frs_card").w("obj_id", byVar.bpE().swan_app_id.longValue()).dY("obj_name", byVar.bpE().name).dY("tid", byVar.getTid()).al("obj_param1", byVar.bpE().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.cJI().a(com.baidu.tieba.frs.d.d.jcU, byVar, 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.i) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.iyv);
        a2.setSourceForPb(3);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(a2);
        amVar.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.ab) this);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.am<by> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bxVar, (bx) amVar);
        if (bxVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tZ().setPage(this.aiw);
        amVar.tZ().setPosition(i);
        amVar.b((com.baidu.card.am<by>) bxVar.eCR);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.hbw);
        bxVar.eCR.bqd();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcT = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void oZ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return jcU;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
            com.baidu.card.am amVar = (com.baidu.card.am) view.getTag();
            by byVar = ((bx) qVar).eCR;
            byVar.objType = 1;
            if (this.hbw != null) {
                this.hbw.a(amVar.getView(), byVar);
            }
            az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), this.jcT, false);
            amVar.tZ().b(new a.C0097a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(by byVar) {
        TiebaStatic.log(new ar("c12126").dY("tid", byVar.getId()).al("obj_locate", cBS() ? 2 : 1).w("obj_id", byVar.bpj() == null ? -1L : byVar.bpj().live_id).al("obj_type", 1));
    }
}
