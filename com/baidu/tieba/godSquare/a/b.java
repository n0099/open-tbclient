package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.f;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab bEO;
    private com.baidu.tieba.godSquare.b.a dLd;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cBv);
        this.bEO = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.dLd != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aik != null && !StringUtils.isNull(fVar.aik.getUserId())) {
                        if (view.getId() != b.this.dLd.dLo.getId()) {
                            if (view.getId() == b.this.dLd.getView().getId() || view.getId() == b.this.dLd.dFa.getId()) {
                                TiebaStatic.log(new am("c10951").ah(VideoPlayActivityConfig.OBJ_ID, fVar.aik.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").r("obj_locate", 4).ah(VideoPlayActivityConfig.OBJ_ID, fVar.aik.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dLd = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.dLd.h(this.mPageContext.getUniqueId());
        this.dLd.b(this.bEO);
        return new a(this.dLd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dLf == null) {
            return null;
        }
        aVar.dLf.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a dLf;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.dLf = aVar;
        }
    }
}
