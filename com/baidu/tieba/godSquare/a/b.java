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
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private z eHS;
    private com.baidu.tieba.godSquare.b.a gPA;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fGT);
        this.eHS = new z() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.gPA != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cNZ != null && !StringUtils.isNull(hVar.cNZ.getUserId())) {
                        if (view.getId() != b.this.gPA.gPL.getId()) {
                            if (view.getId() == b.this.gPA.getView().getId() || view.getId() == b.this.gPA.gLS.getId()) {
                                TiebaStatic.log(new an("c10951").cp("obj_id", hVar.cNZ.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").Z("obj_locate", 4).cp("obj_id", hVar.cNZ.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public a b(ViewGroup viewGroup) {
        this.gPA = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.gPA.j(this.mPageContext.getUniqueId());
        this.gPA.c(this.eHS);
        return new a(this.gPA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gPC == null) {
            return null;
        }
        aVar.gPC.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes8.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.a gPC;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.gPC = aVar;
        }
    }
}
