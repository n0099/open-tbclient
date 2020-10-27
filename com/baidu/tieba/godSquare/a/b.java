package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.i;
/* loaded from: classes24.dex */
public class b extends com.baidu.adp.widget.ListView.a<i, a> {
    private ab gMb;
    private com.baidu.tieba.godSquare.b.a jnd;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), i.hVe);
        this.gMb = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.jnd != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.eyV != null && !StringUtils.isNull(iVar.eyV.getUserId())) {
                        if (view.getId() != b.this.jnd.jno.getId()) {
                            if (view.getId() == b.this.jnd.getView().getId() || view.getId() == b.this.jnd.jjx.getId()) {
                                TiebaStatic.log(new aq("c10951").dR("obj_id", iVar.eyV.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").aj("obj_locate", 4).dR("obj_id", iVar.eyV.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public a c(ViewGroup viewGroup) {
        this.jnd = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.jnd.l(this.mPageContext.getUniqueId());
        this.jnd.c(this.gMb);
        return new a(this.jnd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.jnf == null) {
            return null;
        }
        aVar.jnf.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes24.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.a jnf;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.jnf = aVar;
        }
    }
}
