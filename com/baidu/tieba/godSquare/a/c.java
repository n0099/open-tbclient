package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab dAP;
    private com.baidu.tieba.godSquare.b.b fVl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.eAD);
        this.dAP = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.fVl != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bJa != null && !StringUtils.isNull(fVar.bJa.getUserId())) {
                        if (view.getId() != c.this.fVl.fVt.getId()) {
                            if (view.getId() == c.this.fVl.getView().getId() || view.getId() == c.this.fVl.fRj.getId()) {
                                TiebaStatic.log(new am("c10951").bT(VideoPlayActivityConfig.OBJ_ID, fVar.bJa.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").P("obj_locate", 4).bT(VideoPlayActivityConfig.OBJ_ID, fVar.bJa.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fVl = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.fVl.i(this.mPageContext.getUniqueId());
        this.fVl.d(this.dAP);
        return new a(this.fVl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.fVn == null) {
            return null;
        }
        aVar.fVn.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b fVn;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.fVn = bVar;
        }
    }
}
