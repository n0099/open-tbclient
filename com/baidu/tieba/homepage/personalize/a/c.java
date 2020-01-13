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
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, af<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.e> JE;
    private String Lg;
    private com.baidu.adp.widget.ListView.r Oq;
    private NEGFeedBackView.a dQj;
    public BdUniqueId dxg;
    private int from;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.e eVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            if (this.from == 0) {
                TiebaStatic.log(eVar.btW());
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

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                com.baidu.tieba.card.r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                if (view != null && eVar != null && eVar.axQ() != null && !StringUtils.isNull(eVar.axQ().getTid())) {
                    c.this.a(view, eVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 1;
        dVar.cJD = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(this.from == 0 ? 1 : 9);
        agVar.setShareReportFrom(this.from == 0 ? 3 : 4);
        agVar.aV(this.from == 0 ? 2 : 1);
        aVar.b(agVar);
        aVar.mS().aN(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.mS().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.mS().aO(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        ad a = aVar.a(true, viewGroup, this.Oq);
        a.aM(this.from != 0 ? 1 : 2);
        af<com.baidu.tieba.card.data.e> afVar = new af<>(a);
        afVar.setPageId(this.dxg);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.c.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                c.this.a(view, mVar);
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
        eVar.rm(eVar.position + 1);
        afVar.mU().setPosition(i);
        afVar.mU().setPage(this.Lg);
        if (this.from == 0) {
            afVar.ad(true).a(this.dQj);
            com.baidu.tieba.card.r.btA().c(eVar.btV());
        } else if (this.from == 1) {
            com.baidu.tieba.card.r.btA().c(eVar.zI("c12351"));
        }
        afVar.ae(true);
        afVar.b((af<com.baidu.tieba.card.data.e>) eVar);
        afVar.mU().a(this.JE);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if ((mVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof af)) {
            af afVar = (af) view.getTag();
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) mVar;
            eVar.objType = 1;
            au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), this.from == 0 ? 2 : 1, false);
            afVar.mU().b(new a.C0050a(1));
        }
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Oq = rVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
