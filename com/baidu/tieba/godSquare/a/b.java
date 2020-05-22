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
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private aa fFX;
    private com.baidu.tieba.godSquare.b.a hUY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gGY);
        this.fFX = new aa() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.hUY != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.dFJ != null && !StringUtils.isNull(hVar.dFJ.getUserId())) {
                        if (view.getId() != b.this.hUY.hVj.getId()) {
                            if (view.getId() == b.this.hUY.getView().getId() || view.getId() == b.this.hUY.hRq.getId()) {
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
    /* renamed from: bs */
    public a b(ViewGroup viewGroup) {
        this.hUY = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.hUY.l(this.mPageContext.getUniqueId());
        this.hUY.c(this.fFX);
        return new a(this.hUY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.hVa == null) {
            return null;
        }
        aVar.hVa.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends aa.a {
        public com.baidu.tieba.godSquare.b.a hVa;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.hVa = aVar;
        }
    }
}
