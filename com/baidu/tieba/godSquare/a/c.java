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
/* loaded from: classes24.dex */
public class c extends com.baidu.adp.widget.ListView.a<i, a> {
    private aa gAn;
    private com.baidu.tieba.godSquare.b.b jaL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), i.hII);
        this.gAn = new aa() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.jaL != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.equ != null && !StringUtils.isNull(iVar.equ.getUserId())) {
                        if (view.getId() != c.this.jaL.jaT.getId()) {
                            if (view.getId() == c.this.jaL.getView().getId() || view.getId() == c.this.jaL.iXa.getId()) {
                                TiebaStatic.log(new aq("c10951").dK("obj_id", iVar.equ.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").aj("obj_locate", 4).dK("obj_id", iVar.equ.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
    public a c(ViewGroup viewGroup) {
        this.jaL = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.jaL.l(this.mPageContext.getUniqueId());
        this.jaL.c(this.gAn);
        return new a(this.jaL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.jaN == null) {
            return null;
        }
        aVar.jaN.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes24.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.b jaN;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.jaN = bVar;
        }
    }
}
