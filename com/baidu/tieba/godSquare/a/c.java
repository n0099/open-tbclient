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
    private z eNk;
    private com.baidu.tieba.godSquare.b.b gVl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fMP);
        this.eNk = new z() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gVl != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cSo != null && !StringUtils.isNull(hVar.cSo.getUserId())) {
                        if (view.getId() != c.this.gVl.gVt.getId()) {
                            if (view.getId() == c.this.gVl.getView().getId() || view.getId() == c.this.gVl.gRB.getId()) {
                                TiebaStatic.log(new an("c10951").cy("obj_id", hVar.cSo.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").X("obj_locate", 4).cy("obj_id", hVar.cSo.getUserId()));
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
        this.gVl = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gVl.j(this.mPageContext.getUniqueId());
        this.gVl.c(this.eNk);
        return new a(this.gVl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gVn == null) {
            return null;
        }
        aVar.gVn.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gVn;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gVn = bVar;
        }
    }
}
