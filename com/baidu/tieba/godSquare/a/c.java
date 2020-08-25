package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.i;
/* loaded from: classes18.dex */
public class c extends com.baidu.adp.widget.ListView.a<i, a> {
    private aa giJ;
    private com.baidu.tieba.godSquare.b.b iEs;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), i.hmH);
        this.giJ = new aa() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.iEs != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.ecb != null && !StringUtils.isNull(iVar.ecb.getUserId())) {
                        if (view.getId() != c.this.iEs.iEA.getId()) {
                            if (view.getId() == c.this.iEs.getView().getId() || view.getId() == c.this.iEs.iAH.getId()) {
                                TiebaStatic.log(new aq("c10951").dD("obj_id", iVar.ecb.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").ai("obj_locate", 4).dD("obj_id", iVar.ecb.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public a b(ViewGroup viewGroup) {
        this.iEs = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.iEs.m(this.mPageContext.getUniqueId());
        this.iEs.c(this.giJ);
        return new a(this.iEs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.iEu == null) {
            return null;
        }
        aVar.iEu.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes18.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.b iEu;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.iEu = bVar;
        }
    }
}
