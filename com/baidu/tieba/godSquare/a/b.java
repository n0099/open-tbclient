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
    private aa fGi;
    private com.baidu.tieba.godSquare.b.a hVL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gHj);
        this.fGi = new aa() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.hVL != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.dFJ != null && !StringUtils.isNull(hVar.dFJ.getUserId())) {
                        if (view.getId() != b.this.hVL.hVW.getId()) {
                            if (view.getId() == b.this.hVL.getView().getId() || view.getId() == b.this.hVL.hSd.getId()) {
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
        this.hVL = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.hVL.l(this.mPageContext.getUniqueId());
        this.hVL.c(this.fGi);
        return new a(this.hVL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.hVN == null) {
            return null;
        }
        aVar.hVN.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends aa.a {
        public com.baidu.tieba.godSquare.b.a hVN;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.hVN = aVar;
        }
    }
}
