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
public class c extends com.baidu.adp.widget.ListView.a<h, a> {
    private z eHS;
    private com.baidu.tieba.godSquare.b.b gPD;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fGU);
        this.eHS = new z() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gPD != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cNZ != null && !StringUtils.isNull(hVar.cNZ.getUserId())) {
                        if (view.getId() != c.this.gPD.gPL.getId()) {
                            if (view.getId() == c.this.gPD.getView().getId() || view.getId() == c.this.gPD.gLS.getId()) {
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
    /* renamed from: bb */
    public a b(ViewGroup viewGroup) {
        this.gPD = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gPD.j(this.mPageContext.getUniqueId());
        this.gPD.c(this.eHS);
        return new a(this.gPD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gPF == null) {
            return null;
        }
        aVar.gPF.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes8.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gPF;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gPF = bVar;
        }
    }
}
