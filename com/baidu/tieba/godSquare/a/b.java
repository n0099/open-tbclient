package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.h;
/* loaded from: classes18.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private aa fWK;
    private com.baidu.tieba.godSquare.b.a iqj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gZN);
        this.fWK = new aa() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.iqj != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.dSF != null && !StringUtils.isNull(hVar.dSF.getUserId())) {
                        if (view.getId() != b.this.iqj.iqu.getId()) {
                            if (view.getId() == b.this.iqj.getView().getId() || view.getId() == b.this.iqj.imB.getId()) {
                                TiebaStatic.log(new ap("c10951").dn("obj_id", hVar.dSF.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ap("c10803").ah("obj_locate", 4).dn("obj_id", hVar.dSF.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public a b(ViewGroup viewGroup) {
        this.iqj = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.iqj.m(this.mPageContext.getUniqueId());
        this.iqj.c(this.fWK);
        return new a(this.iqj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.iql == null) {
            return null;
        }
        aVar.iql.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes18.dex */
    public class a extends ad.a {
        public com.baidu.tieba.godSquare.b.a iql;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.iql = aVar;
        }
    }
}
