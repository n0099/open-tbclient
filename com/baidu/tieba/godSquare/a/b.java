package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.f;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ad bGJ;
    private com.baidu.tieba.godSquare.b.a dOu;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.czp);
        this.bGJ = new ad() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.dOu != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aiE != null && !StringUtils.isNull(fVar.aiE.getUserId())) {
                        if (view.getId() != b.this.dOu.dOF.getId()) {
                            if (view.getId() == b.this.dOu.getView().getId() || view.getId() == b.this.dOu.dIv.getId()) {
                                TiebaStatic.log(new an("c10951").ah(VideoPlayActivityConfig.OBJ_ID, fVar.aiE.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").r("obj_locate", 4).ah(VideoPlayActivityConfig.OBJ_ID, fVar.aiE.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dOu = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.dOu.h(this.mPageContext.getUniqueId());
        this.dOu.b(this.bGJ);
        return new a(this.dOu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dOw == null) {
            return null;
        }
        aVar.dOw.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a dOw;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.dOw = aVar;
        }
    }
}
