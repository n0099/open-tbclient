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
    private v clT;
    private com.baidu.tieba.godSquare.b.b eei;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cZW);
        this.clT = new v() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.eei != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aOQ != null && !StringUtils.isNull(fVar.aOQ.getUserId())) {
                        if (view.getId() != c.this.eei.eeq.getId()) {
                            if (view.getId() == c.this.eei.getView().getId() || view.getId() == c.this.eei.dZU.getId()) {
                                TiebaStatic.log(new ak("c10951").ab("obj_id", fVar.aOQ.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ak("c10803").s("obj_locate", 4).ab("obj_id", fVar.aOQ.getUserId()));
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
        this.eei = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.eei.h(this.mPageContext.getUniqueId());
        this.eei.b(this.clT);
        return new a(this.eei);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.eek == null) {
            return null;
        }
        aVar.eek.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends r.a {
        public com.baidu.tieba.godSquare.b.b eek;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.eek = bVar;
        }
    }
}
