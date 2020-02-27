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
public class c extends com.baidu.adp.widget.ListView.a<h, a> {
    private z eMW;
    private com.baidu.tieba.godSquare.b.b gUX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fMA);
        this.eMW = new z() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gUX != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cSm != null && !StringUtils.isNull(hVar.cSm.getUserId())) {
                        if (view.getId() != c.this.gUX.gVf.getId()) {
                            if (view.getId() == c.this.gUX.getView().getId() || view.getId() == c.this.gUX.gRn.getId()) {
                                TiebaStatic.log(new an("c10951").cy("obj_id", hVar.cSm.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").X("obj_locate", 4).cy("obj_id", hVar.cSm.getUserId()));
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
        this.gUX = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gUX.j(this.mPageContext.getUniqueId());
        this.gUX.c(this.eMW);
        return new a(this.gUX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gUZ == null) {
            return null;
        }
        aVar.gUZ.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gUZ;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gUZ = bVar;
        }
    }
}
