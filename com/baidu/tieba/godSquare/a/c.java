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
    private z eMX;
    private com.baidu.tieba.godSquare.b.b gUZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fMC);
        this.eMX = new z() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gUZ != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cSn != null && !StringUtils.isNull(hVar.cSn.getUserId())) {
                        if (view.getId() != c.this.gUZ.gVh.getId()) {
                            if (view.getId() == c.this.gUZ.getView().getId() || view.getId() == c.this.gUZ.gRp.getId()) {
                                TiebaStatic.log(new an("c10951").cy("obj_id", hVar.cSn.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").X("obj_locate", 4).cy("obj_id", hVar.cSn.getUserId()));
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
        this.gUZ = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gUZ.j(this.mPageContext.getUniqueId());
        this.gUZ.c(this.eMX);
        return new a(this.gUZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gVb == null) {
            return null;
        }
        aVar.gVb.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gVb;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gVb = bVar;
        }
    }
}
