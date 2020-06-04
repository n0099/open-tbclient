package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.w;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<bj, ag<bk>> {
    private aa<bk> adt;
    private boolean aha;
    private t aib;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aha = true;
        this.adt = new aa<bk>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                s.bLs().jv(true);
                e.this.f(view, bkVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.epM = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(t tVar) {
        this.aib = tVar;
    }

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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        w wVar = new w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setFromCDN(this.aha);
        aVar.c(wVar);
        ae a = aVar.a(false, viewGroup, this.aib);
        a.setSourceForPb(2);
        ag agVar = new ag(a);
        agVar.setPageId(this.epM);
        a(new x() { // from class: com.baidu.tieba.enterForum.tabfeed.a.e.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bj) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    bk bkVar = ((bj) oVar).dEA;
                    bkVar.objType = 1;
                    if (e.this.adt != null) {
                        e.this.adt.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), 2, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, ag<bk> agVar) {
        if (bjVar == null || agVar == null || agVar.getView() == null || bjVar.dEA == null) {
            return null;
        }
        bjVar.dEA.dDb = getPositionByType(i) + 1;
        agVar.rM().setPosition(i);
        agVar.b((ag<bk>) bjVar.dEA);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        s.bLs().e(com.baidu.tieba.enterForum.a.g(bjVar.aOi(), this.mTabName));
        return agVar.getView();
    }
}
