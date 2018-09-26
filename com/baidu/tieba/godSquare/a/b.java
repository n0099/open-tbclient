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
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ad bNn;
    private com.baidu.tieba.godSquare.b.a dYu;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cHJ);
        this.bNn = new ad() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.dYu != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.akB != null && !StringUtils.isNull(fVar.akB.getUserId())) {
                        if (view.getId() != b.this.dYu.dYF.getId()) {
                            if (view.getId() == b.this.dYu.getView().getId() || view.getId() == b.this.dYu.dSy.getId()) {
                                TiebaStatic.log(new am("c10951").al(VideoPlayActivityConfig.OBJ_ID, fVar.akB.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").w("obj_locate", 4).al(VideoPlayActivityConfig.OBJ_ID, fVar.akB.getUserId()));
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
        this.dYu = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.dYu.h(this.mPageContext.getUniqueId());
        this.dYu.b(this.bNn);
        return new a(this.dYu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dYw == null) {
            return null;
        }
        aVar.dYw.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a dYw;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.dYw = aVar;
        }
    }
}
