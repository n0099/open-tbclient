package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab dEm;
    private com.baidu.tieba.godSquare.b.b gal;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.eFA);
        this.dEm = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gal != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bKb != null && !StringUtils.isNull(fVar.bKb.getUserId())) {
                        if (view.getId() != c.this.gal.gat.getId()) {
                            if (view.getId() == c.this.gal.getView().getId() || view.getId() == c.this.gal.fWj.getId()) {
                                TiebaStatic.log(new an("c10951").bT(VideoPlayActivityConfig.OBJ_ID, fVar.bKb.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").P("obj_locate", 4).bT(VideoPlayActivityConfig.OBJ_ID, fVar.bKb.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.gal = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gal.j(this.mPageContext.getUniqueId());
        this.gal.d(this.dEm);
        return new a(this.gal);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.gan == null) {
            return null;
        }
        aVar.gan.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gan;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gan = bVar;
        }
    }
}
