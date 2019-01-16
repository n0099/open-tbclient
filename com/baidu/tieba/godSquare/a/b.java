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
    private ad cbh;
    private com.baidu.tieba.godSquare.b.a erZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.dbs);
        this.cbh = new ad() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.erZ != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aum != null && !StringUtils.isNull(fVar.aum.getUserId())) {
                        if (view.getId() != b.this.erZ.esk.getId()) {
                            if (view.getId() == b.this.erZ.getView().getId() || view.getId() == b.this.erZ.elM.getId()) {
                                TiebaStatic.log(new am("c10951").aB(VideoPlayActivityConfig.OBJ_ID, fVar.aum.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").y("obj_locate", 4).aB(VideoPlayActivityConfig.OBJ_ID, fVar.aum.getUserId()));
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
        this.erZ = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.erZ.h(this.mPageContext.getUniqueId());
        this.erZ.b(this.cbh);
        return new a(this.erZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.esb == null) {
            return null;
        }
        aVar.esb.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a esb;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.esb = aVar;
        }
    }
}
