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
    private ab dqj;
    private com.baidu.tieba.godSquare.b.a fEl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.ekN);
        this.dqj = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.fEl != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bBJ != null && !StringUtils.isNull(fVar.bBJ.getUserId())) {
                        if (view.getId() != b.this.fEl.fEw.getId()) {
                            if (view.getId() == b.this.fEl.getView().getId() || view.getId() == b.this.fEl.fAm.getId()) {
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
    /* renamed from: aX */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fEl = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.fEl.i(this.mPageContext.getUniqueId());
        this.fEl.d(this.dqj);
        return new a(this.fEl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.fEn == null) {
            return null;
        }
        aVar.fEn.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.a fEn;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.fEn = aVar;
        }
    }
}
