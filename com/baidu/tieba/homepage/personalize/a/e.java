package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.e, ak<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.e> adN;
    private String afx;
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.e eVar) {
        int i = 0;
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(eVar.bSk());
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            i = 2;
        } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(eVar.dLK, this.eEU, eVar.bRX(), i);
        }
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                com.baidu.tieba.card.s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                if (view != null && eVar != null && eVar.aTN() != null && !StringUtils.isNull(eVar.aTN().getTid())) {
                    e.this.a(view, eVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 1;
        cVar.dNH = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(1);
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        aVar.b(alVar);
        aVar.se().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.se().bm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        ai a = aVar.a(true, viewGroup, this.ajt);
        a.setSourceForPb(2);
        ak<com.baidu.tieba.card.data.e> akVar = new ak<>(a);
        akVar.setPageId(this.eEU);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                e.this.a(view, qVar);
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
        eVar.tj(eVar.position + 1);
        akVar.sg().setPosition(i);
        akVar.sg().setPage(this.afx);
        akVar.aK(true).a(this.far);
        akVar.a(eVar.aTY(), this.irz);
        akVar.b((ak<com.baidu.tieba.card.data.e>) eVar);
        akVar.sg().a(this.adN);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.bRL().e(eVar.bSj());
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.far = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ak)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) qVar;
            eVar.objType = 1;
            ax.a((AbsThreadDataSupport) eVar, view.getContext(), 2, false);
            ((ak) view.getTag()).sg().b(new a.C0096a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajt = vVar;
    }
}
