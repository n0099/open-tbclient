package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.h;
/* loaded from: classes24.dex */
public class c extends com.baidu.adp.widget.ListView.a<h, a> {
    private ab hbw;
    private com.baidu.tieba.godSquare.b.b jHm;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.imT);
        this.hbw = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && c.this.jHm != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eKe != null && !StringUtils.isNull(hVar.eKe.getUserId())) {
                        if (view.getId() != c.this.jHm.jHu.getId()) {
                            if (view.getId() == c.this.jHm.getView().getId() || view.getId() == c.this.jHm.jDE.getId()) {
                                TiebaStatic.log(new ar("c10951").dY("obj_id", hVar.eKe.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ar("c10803").al("obj_locate", 4).dY("obj_id", hVar.eKe.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public a c(ViewGroup viewGroup) {
        this.jHm = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.jHm.l(this.mPageContext.getUniqueId());
        this.jHm.c(this.hbw);
        return new a(this.jHm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.jHo == null) {
            return null;
        }
        aVar.jHo.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes24.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.b jHo;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.jHo = bVar;
        }
    }
}
