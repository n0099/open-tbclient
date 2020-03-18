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
/* loaded from: classes11.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private z eNG;
    private com.baidu.tieba.godSquare.b.a gWp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fNw);
        this.eNG = new z() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.gWp != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cSB != null && !StringUtils.isNull(hVar.cSB.getUserId())) {
                        if (view.getId() != b.this.gWp.gWA.getId()) {
                            if (view.getId() == b.this.gWp.getView().getId() || view.getId() == b.this.gWp.gSI.getId()) {
                                TiebaStatic.log(new an("c10951").cx("obj_id", hVar.cSB.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").X("obj_locate", 4).cx("obj_id", hVar.cSB.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public a b(ViewGroup viewGroup) {
        this.gWp = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.gWp.j(this.mPageContext.getUniqueId());
        this.gWp.c(this.eNG);
        return new a(this.gWp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gWr == null) {
            return null;
        }
        aVar.gWr.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.a gWr;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.gWr = aVar;
        }
    }
}
