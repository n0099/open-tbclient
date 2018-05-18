package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.f;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab bwL;
    private com.baidu.tieba.godSquare.b.a dzT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.csQ);
        this.bwL = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.b bVar) {
                if (view2 != null && b.this.dzT != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aaf != null && !StringUtils.isNull(fVar.aaf.getUserId())) {
                        if (view2.getId() != b.this.dzT.dAe.getId()) {
                            if (view2.getId() == b.this.dzT.getView().getId() || view2.getId() == b.this.dzT.dvN.getId()) {
                                TiebaStatic.log(new al("c10951").ac(VideoPlayActivityConfig.OBJ_ID, fVar.aaf.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new al("c10803").r("obj_locate", 4).ac(VideoPlayActivityConfig.OBJ_ID, fVar.aaf.getUserId()));
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
        this.dzT = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.dzT.h(this.mPageContext.getUniqueId());
        this.dzT.b(this.bwL);
        return new a(this.dzT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.dzV == null) {
            return null;
        }
        aVar.dzV.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a dzV;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.dzV = aVar;
        }
    }
}
