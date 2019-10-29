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
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab dTc;
    private com.baidu.tieba.godSquare.b.b gcq;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.ePV);
        this.dTc = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gcq != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.ccm != null && !StringUtils.isNull(fVar.ccm.getUserId())) {
                        if (view.getId() != c.this.gcq.gcy.getId()) {
                            if (view.getId() == c.this.gcq.getView().getId() || view.getId() == c.this.gcq.fYl.getId()) {
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
    /* renamed from: be */
    public a b(ViewGroup viewGroup) {
        this.gcq = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gcq.j(this.mPageContext.getUniqueId());
        this.gcq.d(this.dTc);
        return new a(this.gcq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.gcs == null) {
            return null;
        }
        aVar.gcs.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gcs;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gcs = bVar;
        }
    }
}
