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
    private ab dqj;
    private com.baidu.tieba.godSquare.b.b fEo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.ekO);
        this.dqj = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.fEo != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bBJ != null && !StringUtils.isNull(fVar.bBJ.getUserId())) {
                        if (view.getId() != c.this.fEo.fEw.getId()) {
                            if (view.getId() == c.this.fEo.getView().getId() || view.getId() == c.this.fEo.fAm.getId()) {
                                TiebaStatic.log(new am("c10951").bJ(VideoPlayActivityConfig.OBJ_ID, fVar.bBJ.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").T("obj_locate", 4).bJ(VideoPlayActivityConfig.OBJ_ID, fVar.bBJ.getUserId()));
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
        this.fEo = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.fEo.i(this.mPageContext.getUniqueId());
        this.fEo.d(this.dqj);
        return new a(this.fEo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.fEq == null) {
            return null;
        }
        aVar.fEq.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b fEq;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.fEq = bVar;
        }
    }
}
