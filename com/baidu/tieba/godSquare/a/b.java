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
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private v clH;
    private com.baidu.tieba.godSquare.b.a edT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cZJ);
        this.clH = new v() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.edT != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aOF != null && !StringUtils.isNull(fVar.aOF.getUserId())) {
                        if (view.getId() != b.this.edT.eee.getId()) {
                            if (view.getId() == b.this.edT.getView().getId() || view.getId() == b.this.edT.dZI.getId()) {
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
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.edT = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.edT.h(this.mPageContext.getUniqueId());
        this.edT.b(this.clH);
        return new a(this.edT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.edV == null) {
            return null;
        }
        aVar.edV.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends r.a {
        public com.baidu.tieba.godSquare.b.a edV;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.edV = aVar;
        }
    }
}
