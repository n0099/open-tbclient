package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.h;
/* loaded from: classes11.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private aa fRr;
    private com.baidu.tieba.godSquare.b.a ikg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gUj);
        this.fRr = new aa() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.ikg != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.dMu != null && !StringUtils.isNull(hVar.dMu.getUserId())) {
                        if (view.getId() != b.this.ikg.ikr.getId()) {
                            if (view.getId() == b.this.ikg.getView().getId() || view.getId() == b.this.ikg.igx.getId()) {
                                TiebaStatic.log(new ao("c10951").dk("obj_id", hVar.dMu.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ao("c10803").ag("obj_locate", 4).dk("obj_id", hVar.dMu.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public a b(ViewGroup viewGroup) {
        this.ikg = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.ikg.l(this.mPageContext.getUniqueId());
        this.ikg.c(this.fRr);
        return new a(this.ikg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.iki == null) {
            return null;
        }
        aVar.iki.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends ad.a {
        public com.baidu.tieba.godSquare.b.a iki;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.iki = aVar;
        }
    }
}
