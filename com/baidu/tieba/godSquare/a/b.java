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
    private ad bWB;
    private com.baidu.tieba.godSquare.b.a ehI;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.cRi);
        this.bWB = new ad() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.ehI != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aqk != null && !StringUtils.isNull(fVar.aqk.getUserId())) {
                        if (view.getId() != b.this.ehI.ehT.getId()) {
                            if (view.getId() == b.this.ehI.getView().getId() || view.getId() == b.this.ehI.ebN.getId()) {
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
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ehI = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.ehI.h(this.mPageContext.getUniqueId());
        this.ehI.b(this.bWB);
        return new a(this.ehI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.ehK == null) {
            return null;
        }
        aVar.ehK.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.a ehK;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.ehK = aVar;
        }
    }
}
