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
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab dAQ;
    private com.baidu.tieba.godSquare.b.a fVl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.eAD);
        this.dAQ = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.fVl != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bJb != null && !StringUtils.isNull(fVar.bJb.getUserId())) {
                        if (view.getId() != b.this.fVl.fVw.getId()) {
                            if (view.getId() == b.this.fVl.getView().getId() || view.getId() == b.this.fVl.fRm.getId()) {
                                TiebaStatic.log(new am("c10951").bT(VideoPlayActivityConfig.OBJ_ID, fVar.bJb.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").P("obj_locate", 4).bT(VideoPlayActivityConfig.OBJ_ID, fVar.bJb.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fVl = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.fVl.i(this.mPageContext.getUniqueId());
        this.fVl.d(this.dAQ);
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
        public com.baidu.tieba.godSquare.b.a fVn;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.fVn = aVar;
        }
    }
}
