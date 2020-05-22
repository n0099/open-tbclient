package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<bk, ag<bk>> {
    private aa<bk> adt;
    private t aib;
    private NEGFeedBackView.a eJz;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, bk bkVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bkVar, this.mTabName));
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bkVar, this.mTabName));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bkVar, this.mTabName));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.m(bkVar, this.mTabName));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bkVar, this.mTabName));
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.k(bkVar, this.mTabName));
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<bk>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                s.bLq().jv(true);
                com.baidu.tieba.a.d.blZ().de("page_recommend", "show_");
                if (view != null && bkVar != null && bkVar.aOi() != null && !StringUtils.isNull(bkVar.aOi().getTid())) {
                    a.this.f(view, bkVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.epM = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 1;
        cVar.dBf = 1;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(1);
        ahVar.setShareReportFrom(3);
        ahVar.bm(2);
        aVar.b(ahVar);
        aVar.rK().be(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.rK().bf(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        ae a = aVar.a(true, viewGroup, this.aib);
        a.setSourceForPb(2);
        ag<bk> agVar = new ag<>(a);
        agVar.setPageId(this.epM);
        a(new x() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, oVar);
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, ag<bk> agVar) {
        if (bkVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        bkVar.dDb = getPositionByType(i) + 1;
        agVar.rM().setPosition(i);
        agVar.aH(true).a(this.eJz);
        agVar.a(true, Align.ALIGN_RIGHT_BOTTOM);
        agVar.b((ag<bk>) bkVar);
        agVar.rM().a(this.adt);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        s.bLq().e(com.baidu.tieba.enterForum.a.g(bkVar, this.mTabName));
        return agVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, o oVar) {
        if ((oVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ag)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) oVar;
            eVar.objType = 1;
            au.a((AbsThreadDataSupport) eVar, view.getContext(), 2, false);
            ((ag) view.getTag()).rM().b(new a.C0097a(1));
        }
    }

    public void a(t tVar) {
        this.aib = tVar;
    }
}
