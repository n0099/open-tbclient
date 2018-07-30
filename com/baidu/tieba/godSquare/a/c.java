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
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ad bHy;
    private com.baidu.tieba.godSquare.b.b dRk;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cBW);
        this.bHy = new ad() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.dRk != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aib != null && !StringUtils.isNull(fVar.aib.getUserId())) {
                        if (view.getId() != c.this.dRk.dRs.getId()) {
                            if (view.getId() == c.this.dRk.getView().getId() || view.getId() == c.this.dRk.dLk.getId()) {
                                TiebaStatic.log(new an("c10951").af(VideoPlayActivityConfig.OBJ_ID, fVar.aib.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").r("obj_locate", 4).af(VideoPlayActivityConfig.OBJ_ID, fVar.aib.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dRk = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.dRk.h(this.mPageContext.getUniqueId());
        this.dRk.b(this.bHy);
        return new a(this.dRk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dRm == null) {
            return null;
        }
        aVar.dRm.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.b dRm;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.dRm = bVar;
        }
    }
}
