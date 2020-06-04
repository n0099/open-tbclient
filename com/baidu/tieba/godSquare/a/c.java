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
    private aa fGi;
    private com.baidu.tieba.godSquare.b.b hVO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.gHk);
        this.fGi = new aa() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.hVO != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.dFJ != null && !StringUtils.isNull(hVar.dFJ.getUserId())) {
                        if (view.getId() != c.this.hVO.hVW.getId()) {
                            if (view.getId() == c.this.hVO.getView().getId() || view.getId() == c.this.hVO.hSd.getId()) {
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
        this.hVO = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.hVO.l(this.mPageContext.getUniqueId());
        this.hVO.c(this.fGi);
        return new a(this.hVO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.hVQ == null) {
            return null;
        }
        aVar.hVQ.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends aa.a {
        public com.baidu.tieba.godSquare.b.b hVQ;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.hVQ = bVar;
        }
    }
}
