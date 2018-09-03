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
    private ad bHy;
    private com.baidu.tieba.godSquare.b.a dRc;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cBS);
        this.bHy = new ad() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.dRc != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aib != null && !StringUtils.isNull(fVar.aib.getUserId())) {
                        if (view.getId() != b.this.dRc.dRn.getId()) {
                            if (view.getId() == b.this.dRc.getView().getId() || view.getId() == b.this.dRc.dLg.getId()) {
                                TiebaStatic.log(new an("c10951").ae(VideoPlayActivityConfig.OBJ_ID, fVar.aib.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").r("obj_locate", 4).ae(VideoPlayActivityConfig.OBJ_ID, fVar.aib.getUserId()));
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
        this.dRc = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.dRc.h(this.mPageContext.getUniqueId());
        this.dRc.b(this.bHy);
        return new a(this.dRc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dRe == null) {
            return null;
        }
        aVar.dRe.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a dRe;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.dRe = aVar;
        }
    }
}
