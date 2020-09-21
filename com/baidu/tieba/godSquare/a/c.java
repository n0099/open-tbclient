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
public class c extends com.baidu.adp.widget.ListView.a<i, a> {
    private aa glU;
    private com.baidu.tieba.godSquare.b.b iLT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), i.htO);
        this.glU = new aa() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.iLT != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.eep != null && !StringUtils.isNull(iVar.eep.getUserId())) {
                        if (view.getId() != c.this.iLT.iMb.getId()) {
                            if (view.getId() == c.this.iLT.getView().getId() || view.getId() == c.this.iLT.iIi.getId()) {
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
    /* renamed from: by */
    public a c(ViewGroup viewGroup) {
        this.iLT = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.iLT.l(this.mPageContext.getUniqueId());
        this.iLT.c(this.glU);
        return new a(this.iLT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.iLV == null) {
            return null;
        }
        aVar.iLV.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes23.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.b iLV;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.iLV = bVar;
        }
    }
}
