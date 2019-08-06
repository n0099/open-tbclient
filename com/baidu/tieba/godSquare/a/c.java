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
    private ab dEt;
    private com.baidu.tieba.godSquare.b.b gbb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.eFH);
        this.dEt = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gbb != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bKg != null && !StringUtils.isNull(fVar.bKg.getUserId())) {
                        if (view.getId() != c.this.gbb.gbj.getId()) {
                            if (view.getId() == c.this.gbb.getView().getId() || view.getId() == c.this.gbb.fWZ.getId()) {
                                TiebaStatic.log(new an("c10951").bT(VideoPlayActivityConfig.OBJ_ID, fVar.bKg.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").P("obj_locate", 4).bT(VideoPlayActivityConfig.OBJ_ID, fVar.bKg.getUserId()));
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
        this.gbb = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gbb.j(this.mPageContext.getUniqueId());
        this.gbb.d(this.dEt);
        return new a(this.gbb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.gbd == null) {
            return null;
        }
        aVar.gbd.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gbd;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gbd = bVar;
        }
    }
}
