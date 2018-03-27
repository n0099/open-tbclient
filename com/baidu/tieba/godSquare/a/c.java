package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.v;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private v clK;
    private com.baidu.tieba.godSquare.b.b eem;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cZN);
        this.clK = new v() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.eem != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aOG != null && !StringUtils.isNull(fVar.aOG.getUserId())) {
                        if (view.getId() != c.this.eem.eeu.getId()) {
                            if (view.getId() == c.this.eem.getView().getId() || view.getId() == c.this.eem.dZY.getId()) {
                                TiebaStatic.log(new ak("c10951").ab("obj_id", fVar.aOG.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ak("c10803").s("obj_locate", 4).ab("obj_id", fVar.aOG.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.eem = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.eem.h(this.mPageContext.getUniqueId());
        this.eem.b(this.clK);
        return new a(this.eem);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.eeo == null) {
            return null;
        }
        aVar.eeo.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends r.a {
        public com.baidu.tieba.godSquare.b.b eeo;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.eeo = bVar;
        }
    }
}
