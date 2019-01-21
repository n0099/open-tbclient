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
    private ad cbi;
    private com.baidu.tieba.godSquare.b.b esd;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.dbu);
        this.cbi = new ad() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.esd != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.aun != null && !StringUtils.isNull(fVar.aun.getUserId())) {
                        if (view.getId() != c.this.esd.esl.getId()) {
                            if (view.getId() == c.this.esd.getView().getId() || view.getId() == c.this.esd.elN.getId()) {
                                TiebaStatic.log(new am("c10951").aB(VideoPlayActivityConfig.OBJ_ID, fVar.aun.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").y("obj_locate", 4).aB(VideoPlayActivityConfig.OBJ_ID, fVar.aun.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.esd = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.esd.h(this.mPageContext.getUniqueId());
        this.esd.b(this.cbi);
        return new a(this.esd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.esf == null) {
            return null;
        }
        aVar.esf.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.godSquare.b.b esf;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.esf = bVar;
        }
    }
}
