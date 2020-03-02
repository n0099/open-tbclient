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
    private z eMX;
    private com.baidu.tieba.godSquare.b.a gUW;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fMB);
        this.eMX = new z() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.gUW != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cSn != null && !StringUtils.isNull(hVar.cSn.getUserId())) {
                        if (view.getId() != b.this.gUW.gVh.getId()) {
                            if (view.getId() == b.this.gUW.getView().getId() || view.getId() == b.this.gUW.gRp.getId()) {
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
    /* renamed from: be */
    public a b(ViewGroup viewGroup) {
        this.gUW = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.gUW.j(this.mPageContext.getUniqueId());
        this.gUW.c(this.eMX);
        return new a(this.gUW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gUY == null) {
            return null;
        }
        aVar.gUY.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.a gUY;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.gUY = aVar;
        }
    }
}
