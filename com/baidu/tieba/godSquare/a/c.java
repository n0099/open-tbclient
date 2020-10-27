package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.i;
/* loaded from: classes24.dex */
public class c extends com.baidu.adp.widget.ListView.a<i, a> {
    private ab gMb;
    private com.baidu.tieba.godSquare.b.b jng;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), i.hVf);
        this.gMb = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.jng != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.eyV != null && !StringUtils.isNull(iVar.eyV.getUserId())) {
                        if (view.getId() != c.this.jng.jno.getId()) {
                            if (view.getId() == c.this.jng.getView().getId() || view.getId() == c.this.jng.jjx.getId()) {
                                TiebaStatic.log(new aq("c10951").dR("obj_id", iVar.eyV.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").aj("obj_locate", 4).dR("obj_id", iVar.eyV.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
    public a c(ViewGroup viewGroup) {
        this.jng = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.jng.l(this.mPageContext.getUniqueId());
        this.jng.c(this.gMb);
        return new a(this.jng);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.jni == null) {
            return null;
        }
        aVar.jni.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes24.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.b jni;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.jni = bVar;
        }
    }
}
