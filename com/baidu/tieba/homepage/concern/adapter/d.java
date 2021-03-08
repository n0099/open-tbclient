package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, ThreadCardViewHolder<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.e> ahy;
    private String ajx;
    private com.baidu.adp.widget.ListView.s anC;
    public BdUniqueId fIy;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.e eVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, eVar, 2);
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            com.baidu.tieba.homepage.concern.c.a(view, eVar, 1);
        } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
            com.baidu.tieba.homepage.concern.c.a(view, eVar, 3);
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new ab<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.homepage.concern.adapter.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                com.baidu.tieba.card.t.csH().mG(true);
                com.baidu.tieba.a.d.bKY().dK("page_recommend", "show_");
                if (view != null && eVar != null && eVar.blp() != null && !StringUtils.isNull(eVar.blp().getTid())) {
                    d.this.a(view, eVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.e> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fIy);
        dVar.b(this.mPageContext);
        aVar.a(dVar);
        aVar.c(new com.baidu.card.b(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 1;
        eVar.eNH = 1;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(9);
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        aVar.b(amVar);
        aVar.ti().by(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.anC);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.e> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fIy);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.d.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                d.this.a(view, nVar);
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, ThreadCardViewHolder<com.baidu.tieba.card.data.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        eVar.xe(eVar.position + 1);
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.tj().setPage(this.ajx);
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.tm();
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.e>) eVar);
        com.baidu.tieba.card.t.csH().e(eVar.Jc("c12351"));
        threadCardViewHolder.tj().a(this.ahy);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.n nVar) {
        if ((nVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) nVar;
            eVar.objType = 1;
            az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 1, false);
            ((ThreadCardViewHolder) view.getTag()).tj().b(new a.C0095a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anC = sVar;
    }
}
