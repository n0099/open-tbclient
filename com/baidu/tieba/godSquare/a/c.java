package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.h;
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.widget.ListView.a<h, a> {
    private aa fFX;
    private com.baidu.tieba.godSquare.b.b hVb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gGZ);
        this.fFX = new aa() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.hVb != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.dFJ != null && !StringUtils.isNull(hVar.dFJ.getUserId())) {
                        if (view.getId() != c.this.hVb.hVj.getId()) {
                            if (view.getId() == c.this.hVb.getView().getId() || view.getId() == c.this.hVb.hRq.getId()) {
                                TiebaStatic.log(new an("c10951").dh("obj_id", hVar.dFJ.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").ag("obj_locate", 4).dh("obj_id", hVar.dFJ.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public a b(ViewGroup viewGroup) {
        this.hVb = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.hVb.l(this.mPageContext.getUniqueId());
        this.hVb.c(this.fFX);
        return new a(this.hVb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.hVd == null) {
            return null;
        }
        aVar.hVd.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends aa.a {
        public com.baidu.tieba.godSquare.b.b hVd;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.hVd = bVar;
        }
    }
}
