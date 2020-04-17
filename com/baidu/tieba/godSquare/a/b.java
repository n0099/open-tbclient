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
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private z fsa;
    private com.baidu.tieba.godSquare.b.a hGg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gsd);
        this.fsa = new z() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.hGg != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.drK != null && !StringUtils.isNull(hVar.drK.getUserId())) {
                        if (view.getId() != b.this.hGg.hGr.getId()) {
                            if (view.getId() == b.this.hGg.getView().getId() || view.getId() == b.this.hGg.hCx.getId()) {
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
    /* renamed from: bh */
    public a b(ViewGroup viewGroup) {
        this.hGg = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.hGg.j(this.mPageContext.getUniqueId());
        this.hGg.c(this.fsa);
        return new a(this.hGg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.hGi == null) {
            return null;
        }
        aVar.hGi.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends y.a {
        public com.baidu.tieba.godSquare.b.a hGi;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.hGi = aVar;
        }
    }
}
