package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.f;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private ad bVP;
    private com.baidu.tieba.godSquare.b.a ego;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cQc);
        this.bVP = new ad() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.ego != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.apx != null && !StringUtils.isNull(fVar.apx.getUserId())) {
                        if (view.getId() != b.this.ego.egz.getId()) {
                            if (view.getId() == b.this.ego.getView().getId() || view.getId() == b.this.ego.eat.getId()) {
                                TiebaStatic.log(new am("c10951").ax(VideoPlayActivityConfig.OBJ_ID, fVar.apx.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").x("obj_locate", 4).ax(VideoPlayActivityConfig.OBJ_ID, fVar.apx.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ego = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.ego.h(this.mPageContext.getUniqueId());
        this.ego.b(this.bVP);
        return new a(this.ego);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.egq == null) {
            return null;
        }
        aVar.egq.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a egq;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.egq = aVar;
        }
    }
}
