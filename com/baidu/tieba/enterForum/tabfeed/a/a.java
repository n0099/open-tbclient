package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<bj, af<bj>> {
    private z<bj> acX;
    private r ahv;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bj bjVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bjVar, this.mTabName));
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bjVar, this.mTabName));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bjVar, this.mTabName));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.m(bjVar, this.mTabName));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bjVar, this.mTabName));
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.k(bjVar, this.mTabName));
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acX = new z<bj>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                com.baidu.tieba.card.r.bEY().jd(true);
                com.baidu.tieba.a.d.bfP().cF("page_recommend", "show_");
                if (view != null && bjVar != null && bjVar.aIw() != null && !StringUtils.isNull(bjVar.aIw().getTid())) {
                    a.this.e(view, bjVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ebv = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<bj> b(ViewGroup viewGroup) {
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
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.bl(2);
        aVar.b(agVar);
        aVar.rB().bd(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.rB().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.rB().be(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        ad a = aVar.a(true, viewGroup, this.ahv);
        a.bc(2);
        af<bj> afVar = new af<>(a);
        afVar.setPageId(this.ebv);
        a(new v() { // from class: com.baidu.tieba.enterForum.tabfeed.a.a.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, mVar);
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, af<bj> afVar) {
        if (bjVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        bjVar.doZ = getPositionByType(i) + 1;
        afVar.rD().setPosition(i);
        afVar.aF(true).a(this.euS);
        afVar.aG(true);
        afVar.b((af<bj>) bjVar);
        afVar.rD().a(this.acX);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.r.bEY().e(com.baidu.tieba.enterForum.a.g(bjVar, this.mTabName));
        return afVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if ((mVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof af)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) mVar;
            eVar.objType = 1;
            au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 2, false);
            ((af) view.getTag()).rD().b(new a.C0074a(1));
        }
    }

    public void a(r rVar) {
        this.ahv = rVar;
    }
}
