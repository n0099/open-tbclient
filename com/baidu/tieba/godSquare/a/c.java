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
    private ab dAQ;
    private com.baidu.tieba.godSquare.b.b fVo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.eAE);
        this.dAQ = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.fVo != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bJb != null && !StringUtils.isNull(fVar.bJb.getUserId())) {
                        if (view.getId() != c.this.fVo.fVw.getId()) {
                            if (view.getId() == c.this.fVo.getView().getId() || view.getId() == c.this.fVo.fRm.getId()) {
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
    /* renamed from: aY */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fVo = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.fVo.i(this.mPageContext.getUniqueId());
        this.fVo.d(this.dAQ);
        return new a(this.fVo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.fVq == null) {
            return null;
        }
        aVar.fVq.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b fVq;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.fVq = bVar;
        }
    }
}
