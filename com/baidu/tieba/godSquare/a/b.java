package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.i;
/* loaded from: classes23.dex */
public class b extends com.baidu.adp.widget.ListView.a<i, a> {
    private aa glU;
    private com.baidu.tieba.godSquare.b.a iLQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), i.htN);
        this.glU = new aa() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.iLQ != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.eep != null && !StringUtils.isNull(iVar.eep.getUserId())) {
                        if (view.getId() != b.this.iLQ.iMb.getId()) {
                            if (view.getId() == b.this.iLQ.getView().getId() || view.getId() == b.this.iLQ.iIi.getId()) {
                                TiebaStatic.log(new aq("c10951").dF("obj_id", iVar.eep.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").ai("obj_locate", 4).dF("obj_id", iVar.eep.getUserId()));
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
    public a c(ViewGroup viewGroup) {
        this.iLQ = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.iLQ.l(this.mPageContext.getUniqueId());
        this.iLQ.c(this.glU);
        return new a(this.iLQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.iLS == null) {
            return null;
        }
        aVar.iLS.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes23.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.a iLS;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.iLS = aVar;
        }
    }
}
