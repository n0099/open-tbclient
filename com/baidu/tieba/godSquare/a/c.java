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
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ad bVP;
    private com.baidu.tieba.godSquare.b.b egr;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cQd);
        this.bVP = new ad() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.egr != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.apx != null && !StringUtils.isNull(fVar.apx.getUserId())) {
                        if (view.getId() != c.this.egr.egz.getId()) {
                            if (view.getId() == c.this.egr.getView().getId() || view.getId() == c.this.egr.eat.getId()) {
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
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.egr = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.egr.h(this.mPageContext.getUniqueId());
        this.egr.b(this.bVP);
        return new a(this.egr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.egt == null) {
            return null;
        }
        aVar.egt.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.b egt;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.egt = bVar;
        }
    }
}
