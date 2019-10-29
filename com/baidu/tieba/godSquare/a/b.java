package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab dTc;
    private com.baidu.tieba.godSquare.b.a gcn;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.ePU);
        this.dTc = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.gcn != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.ccm != null && !StringUtils.isNull(fVar.ccm.getUserId())) {
                        if (view.getId() != b.this.gcn.gcy.getId()) {
                            if (view.getId() == b.this.gcn.getView().getId() || view.getId() == b.this.gcn.fYl.getId()) {
                                TiebaStatic.log(new an("c10951").bS("obj_id", fVar.ccm.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").O("obj_locate", 4).bS("obj_id", fVar.ccm.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a b(ViewGroup viewGroup) {
        this.gcn = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.gcn.j(this.mPageContext.getUniqueId());
        this.gcn.d(this.dTc);
        return new a(this.gcn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.gcp == null) {
            return null;
        }
        aVar.gcp.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.a gcp;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.gcp = aVar;
        }
    }
}
