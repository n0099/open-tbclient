package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, af<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.e> acX;
    private String aey;
    private com.baidu.adp.widget.ListView.r ahv;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    private int from;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.e eVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            if (this.from == 0) {
                TiebaStatic.log(eVar.bFt());
            } else if (this.from == 1) {
                com.baidu.tieba.homepage.concern.b.a(view, eVar, 2);
            }
        } else if (id == R.id.user_avatar || id == R.id.user_name) {
            if (this.from == 1) {
                com.baidu.tieba.homepage.concern.b.a(view, eVar, 1);
            }
        } else if ((id == R.id.cover_img || id == R.id.bottom_mask) && this.from == 1) {
            com.baidu.tieba.homepage.concern.b.a(view, eVar, 3);
        }
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acX = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                com.baidu.tieba.card.r.bEY().jd(true);
                com.baidu.tieba.a.d.bfP().cF("page_recommend", "show_");
                if (view != null && eVar != null && eVar.aIw() != null && !StringUtils.isNull(eVar.aIw().getTid())) {
                    e.this.a(view, eVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebv);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 1;
        dVar.dmZ = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(this.from == 0 ? 1 : 9);
        agVar.setShareReportFrom(this.from == 0 ? 3 : 4);
        agVar.bl(this.from == 0 ? 2 : 1);
        aVar.b(agVar);
        aVar.rB().bd(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.rB().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.rB().be(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        com.baidu.card.ad a = aVar.a(true, viewGroup, this.ahv);
        a.bc(this.from != 0 ? 1 : 2);
        af<com.baidu.tieba.card.data.e> afVar = new af<>(a);
        afVar.setPageId(this.ebv);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                e.this.a(view, mVar);
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, af<com.baidu.tieba.card.data.e> afVar) {
        if (eVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        eVar.rN(eVar.position + 1);
        afVar.rD().setPosition(i);
        afVar.rD().setPage(this.aey);
        if (this.from == 0) {
            afVar.aF(true).a(this.euS);
            com.baidu.tieba.card.r.bEY().e(eVar.bFs());
        } else if (this.from == 1) {
            com.baidu.tieba.card.r.bEY().e(eVar.BH("c12351"));
        }
        afVar.aG(true);
        afVar.b((af<com.baidu.tieba.card.data.e>) eVar);
        afVar.rD().a(this.acX);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if ((mVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof af)) {
            af afVar = (af) view.getTag();
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) mVar;
            eVar.objType = 1;
            au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), this.from == 0 ? 2 : 1, false);
            afVar.rD().b(new a.C0074a(1));
        }
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahv = rVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
