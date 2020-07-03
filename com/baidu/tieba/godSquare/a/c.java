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
public class c extends com.baidu.adp.widget.ListView.a<h, a> {
    private aa fRr;
    private com.baidu.tieba.godSquare.b.b ikj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gUk);
        this.fRr = new aa() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.ikj != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.dMu != null && !StringUtils.isNull(hVar.dMu.getUserId())) {
                        if (view.getId() != c.this.ikj.ikr.getId()) {
                            if (view.getId() == c.this.ikj.getView().getId() || view.getId() == c.this.ikj.igx.getId()) {
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
    /* renamed from: bx */
    public a b(ViewGroup viewGroup) {
        this.ikj = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.ikj.l(this.mPageContext.getUniqueId());
        this.ikj.c(this.fRr);
        return new a(this.ikj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.ikl == null) {
            return null;
        }
        aVar.ikl.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends ad.a {
        public com.baidu.tieba.godSquare.b.b ikl;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.ikl = bVar;
        }
    }
}
