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
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab dGe;
    private com.baidu.tieba.godSquare.b.a gcP;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.eHp);
        this.dGe = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.gcP != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bKE != null && !StringUtils.isNull(fVar.bKE.getUserId())) {
                        if (view.getId() != b.this.gcP.gda.getId()) {
                            if (view.getId() == b.this.gcP.getView().getId() || view.getId() == b.this.gcP.fYQ.getId()) {
                                TiebaStatic.log(new an("c10951").bT(VideoPlayActivityConfig.OBJ_ID, fVar.bKE.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").P("obj_locate", 4).bT(VideoPlayActivityConfig.OBJ_ID, fVar.bKE.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.gcP = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.gcP.j(this.mPageContext.getUniqueId());
        this.gcP.d(this.dGe);
        return new a(this.gcP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.gcR == null) {
            return null;
        }
        aVar.gcR.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.a gcR;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.gcR = aVar;
        }
    }
}
