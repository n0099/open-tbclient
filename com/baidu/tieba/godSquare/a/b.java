package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private z eJc;
    private com.baidu.tieba.godSquare.b.a gSU;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fKd);
        this.eJc = new z() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.gSU != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cOj != null && !StringUtils.isNull(hVar.cOj.getUserId())) {
                        if (view.getId() != b.this.gSU.gTf.getId()) {
                            if (view.getId() == b.this.gSU.getView().getId() || view.getId() == b.this.gSU.gPn.getId()) {
                                TiebaStatic.log(new an("c10951").cp("obj_id", hVar.cOj.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").Z("obj_locate", 4).cp("obj_id", hVar.cOj.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public a b(ViewGroup viewGroup) {
        this.gSU = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.gSU.j(this.mPageContext.getUniqueId());
        this.gSU.c(this.eJc);
        return new a(this.gSU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gSW == null) {
            return null;
        }
        aVar.gSW.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.a gSW;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.gSW = aVar;
        }
    }
}
