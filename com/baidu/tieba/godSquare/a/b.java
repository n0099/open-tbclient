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
    private com.baidu.tieba.godSquare.b.a egn;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cQc);
        this.bVP = new ad() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.egn != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.apx != null && !StringUtils.isNull(fVar.apx.getUserId())) {
                        if (view.getId() != b.this.egn.egy.getId()) {
                            if (view.getId() == b.this.egn.getView().getId() || view.getId() == b.this.egn.eas.getId()) {
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
        this.egn = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.egn.h(this.mPageContext.getUniqueId());
        this.egn.b(this.bVP);
        return new a(this.egn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.egp == null) {
            return null;
        }
        aVar.egp.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a egp;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.egp = aVar;
        }
    }
}
