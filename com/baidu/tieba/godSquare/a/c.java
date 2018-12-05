package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.f;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ad cat;
    private com.baidu.tieba.godSquare.b.b eoF;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cXQ);
        this.cat = new ad() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.eoF != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.atK != null && !StringUtils.isNull(fVar.atK.getUserId())) {
                        if (view.getId() != c.this.eoF.eoN.getId()) {
                            if (view.getId() == c.this.eoF.getView().getId() || view.getId() == c.this.eoF.eiq.getId()) {
                                TiebaStatic.log(new am("c10951").aA(VideoPlayActivityConfig.OBJ_ID, fVar.atK.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").x("obj_locate", 4).aA(VideoPlayActivityConfig.OBJ_ID, fVar.atK.getUserId()));
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
        this.eoF = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.eoF.h(this.mPageContext.getUniqueId());
        this.eoF.b(this.cat);
        return new a(this.eoF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.eoH == null) {
            return null;
        }
        aVar.eoH.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.b eoH;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.eoH = bVar;
        }
    }
}
