package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.f;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab bvU;
    private com.baidu.tieba.godSquare.b.b dyS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.crL);
        this.bvU = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.b bVar) {
                if (view2 != null && c.this.dyS != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aae != null && !StringUtils.isNull(fVar.aae.getUserId())) {
                        if (view2.getId() != c.this.dyS.dza.getId()) {
                            if (view2.getId() == c.this.dyS.getView().getId() || view2.getId() == c.this.dyS.duI.getId()) {
                                TiebaStatic.log(new al("c10951").ac(VideoPlayActivityConfig.OBJ_ID, fVar.aae.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new al("c10803").r("obj_locate", 4).ac(VideoPlayActivityConfig.OBJ_ID, fVar.aae.getUserId()));
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
        this.dyS = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.dyS.h(this.mPageContext.getUniqueId());
        this.dyS.b(this.bvU);
        return new a(this.dyS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dyU == null) {
            return null;
        }
        aVar.dyU.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.b dyU;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.dyU = bVar;
        }
    }
}
