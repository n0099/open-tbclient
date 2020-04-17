package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.z;
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.widget.ListView.a<h, a> {
    private z fsa;
    private com.baidu.tieba.godSquare.b.b hGj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gse);
        this.fsa = new z() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.hGj != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.drK != null && !StringUtils.isNull(hVar.drK.getUserId())) {
                        if (view.getId() != c.this.hGj.hGr.getId()) {
                            if (view.getId() == c.this.hGj.getView().getId() || view.getId() == c.this.hGj.hCx.getId()) {
                                TiebaStatic.log(new an("c10951").cI("obj_id", hVar.drK.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").af("obj_locate", 4).cI("obj_id", hVar.drK.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a b(ViewGroup viewGroup) {
        this.hGj = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.hGj.j(this.mPageContext.getUniqueId());
        this.hGj.c(this.fsa);
        return new a(this.hGj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.hGl == null) {
            return null;
        }
        aVar.hGl.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends y.a {
        public com.baidu.tieba.godSquare.b.b hGl;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.hGl = bVar;
        }
    }
}
