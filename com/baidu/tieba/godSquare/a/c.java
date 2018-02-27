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
    private v clH;
    private com.baidu.tieba.godSquare.b.b edW;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cZK);
        this.clH = new v() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.edW != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aOF != null && !StringUtils.isNull(fVar.aOF.getUserId())) {
                        if (view.getId() != c.this.edW.eee.getId()) {
                            if (view.getId() == c.this.edW.getView().getId() || view.getId() == c.this.edW.dZI.getId()) {
                                TiebaStatic.log(new ak("c10951").ab("obj_id", fVar.aOF.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ak("c10803").s("obj_locate", 4).ab("obj_id", fVar.aOF.getUserId()));
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
        this.edW = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.edW.h(this.mPageContext.getUniqueId());
        this.edW.b(this.clH);
        return new a(this.edW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.edY == null) {
            return null;
        }
        aVar.edY.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends r.a {
        public com.baidu.tieba.godSquare.b.b edY;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.edY = bVar;
        }
    }
}
