package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, ak<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.e> adX;
    private String afG;
    private com.baidu.adp.widget.ListView.v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.e eVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, eVar, 2);
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            com.baidu.tieba.homepage.concern.b.a(view, eVar, 1);
        } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
            com.baidu.tieba.homepage.concern.b.a(view, eVar, 3);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new aa<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                com.baidu.tieba.card.s.bOB().jI(true);
                com.baidu.tieba.a.d.boB().dh("page_recommend", "show_");
                if (view != null && eVar != null && eVar.aPS() != null && !StringUtils.isNull(eVar.aPS().getTid())) {
                    b.this.a(view, eVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 1;
        cVar.dHw = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(9);
        alVar.setShareReportFrom(4);
        alVar.setFromForPb(1);
        aVar.b(alVar);
        aVar.sc().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.sc().bk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        ai a = aVar.a(true, viewGroup, this.ajy);
        a.setSourceForPb(1);
        ak<com.baidu.tieba.card.data.e> akVar = new ak<>(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                b.this.a(view, qVar);
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, ak<com.baidu.tieba.card.data.e> akVar) {
        if (eVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        eVar.sR(eVar.position + 1);
        akVar.se().setPosition(i);
        akVar.se().setPage(this.afG);
        akVar.a(true, eVar.aPZ() ? Align.ALIGN_RIGHT_TOP : Align.ALIGN_RIGHT_BOTTOM);
        akVar.b((ak<com.baidu.tieba.card.data.e>) eVar);
        com.baidu.tieba.card.s.bOB().e(eVar.DU("c12351"));
        akVar.se().a(this.adX);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ak)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) qVar;
            eVar.objType = 1;
            aw.a((AbsThreadDataSupport) eVar, view.getContext(), 1, false);
            ((ak) view.getTag()).se().b(new a.C0098a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }
}
