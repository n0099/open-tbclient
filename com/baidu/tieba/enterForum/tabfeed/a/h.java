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
import com.baidu.card.e;
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
public class h extends com.baidu.adp.widget.ListView.a<bj, ag<bk>> {
    private aa<bk> adt;
    private t aib;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<bk>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                s.bLq().jv(true);
                h.this.f(view, bkVar);
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
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aY(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.h.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        ae a = aVar.a(false, viewGroup, this.aib);
        a.setSourceForPb(2);
        ag agVar = new ag(a);
        agVar.setPageId(this.epM);
        a(new x() { // from class: com.baidu.tieba.enterForum.tabfeed.a.h.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bj) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    bk bkVar = ((bj) oVar).dEA;
                    bkVar.objType = 1;
                    if (h.this.adt != null) {
                        h.this.adt.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), 2, false, com.baidu.card.f.a((t) viewGroup2, view, i));
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
        return agVar.getView();
    }
}
