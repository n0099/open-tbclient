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
    private ad bWB;
    private com.baidu.tieba.godSquare.b.b ehL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cRj);
        this.bWB = new ad() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.ehL != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aqk != null && !StringUtils.isNull(fVar.aqk.getUserId())) {
                        if (view.getId() != c.this.ehL.ehT.getId()) {
                            if (view.getId() == c.this.ehL.getView().getId() || view.getId() == c.this.ehL.ebN.getId()) {
                                TiebaStatic.log(new am("c10951").ax(VideoPlayActivityConfig.OBJ_ID, fVar.aqk.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").x("obj_locate", 4).ax(VideoPlayActivityConfig.OBJ_ID, fVar.aqk.getUserId()));
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
        this.ehL = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.ehL.h(this.mPageContext.getUniqueId());
        this.ehL.b(this.bWB);
        return new a(this.ehL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.ehN == null) {
            return null;
        }
        aVar.ehN.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.b ehN;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.ehN = bVar;
        }
    }
}
