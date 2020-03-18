package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.z;
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.widget.ListView.a<h, a> {
    private z eNG;
    private com.baidu.tieba.godSquare.b.b gWs;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.fNx);
        this.eNG = new z() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.gWs != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    if (hVar.cSB != null && !StringUtils.isNull(hVar.cSB.getUserId())) {
                        if (view.getId() != c.this.gWs.gWA.getId()) {
                            if (view.getId() == c.this.gWs.getView().getId() || view.getId() == c.this.gWs.gSI.getId()) {
                                TiebaStatic.log(new an("c10951").cx("obj_id", hVar.cSB.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10803").X("obj_locate", 4).cx("obj_id", hVar.cSB.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        this.gWs = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.gWs.j(this.mPageContext.getUniqueId());
        this.gWs.c(this.eNG);
        return new a(this.gWs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.gWu == null) {
            return null;
        }
        aVar.gWu.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes11.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b gWu;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.gWu = bVar;
        }
    }
}
