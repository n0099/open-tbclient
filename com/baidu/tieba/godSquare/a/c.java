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
public class c extends com.baidu.adp.widget.ListView.a<i, a> {
    private ab gSA;
    private com.baidu.tieba.godSquare.b.b jtd;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), i.ibc);
        this.gSA = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.jtd != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.eEK != null && !StringUtils.isNull(iVar.eEK.getUserId())) {
                        if (view.getId() != c.this.jtd.jtl.getId()) {
                            if (view.getId() == c.this.jtd.getView().getId() || view.getId() == c.this.jtd.jpv.getId()) {
                                TiebaStatic.log(new aq("c10951").dR("obj_id", iVar.eEK.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").al("obj_locate", 4).dR("obj_id", iVar.eEK.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public a c(ViewGroup viewGroup) {
        this.jtd = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.jtd.l(this.mPageContext.getUniqueId());
        this.jtd.c(this.gSA);
        return new a(this.jtd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.jtf == null) {
            return null;
        }
        aVar.jtf.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes24.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.b jtf;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.jtf = bVar;
        }
    }
}
