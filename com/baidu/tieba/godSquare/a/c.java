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
    private ad bGJ;
    private com.baidu.tieba.godSquare.b.b dOx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.czq);
        this.bGJ = new ad() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.dOx != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aiE != null && !StringUtils.isNull(fVar.aiE.getUserId())) {
                        if (view.getId() != c.this.dOx.dOF.getId()) {
                            if (view.getId() == c.this.dOx.getView().getId() || view.getId() == c.this.dOx.dIv.getId()) {
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
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dOx = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.dOx.h(this.mPageContext.getUniqueId());
        this.dOx.b(this.bGJ);
        return new a(this.dOx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dOz == null) {
            return null;
        }
        aVar.dOz.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.b dOz;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.dOz = bVar;
        }
    }
}
