package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.i;
/* loaded from: classes18.dex */
public class b extends com.baidu.adp.widget.ListView.a<i, a> {
    private aa giN;
    private com.baidu.tieba.godSquare.b.a iEv;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), i.hmK);
        this.giN = new aa() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && b.this.iEv != null && (bVar instanceof i)) {
                    i iVar = (i) bVar;
                    if (iVar.ecf != null && !StringUtils.isNull(iVar.ecf.getUserId())) {
                        if (view.getId() != b.this.iEv.iEG.getId()) {
                            if (view.getId() == b.this.iEv.getView().getId() || view.getId() == b.this.iEv.iAN.getId()) {
                                TiebaStatic.log(new aq("c10951").dD("obj_id", iVar.ecf.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").ai("obj_locate", 4).dD("obj_id", iVar.ecf.getUserId()));
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
        this.iEv = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.iEv.m(this.mPageContext.getUniqueId());
        this.iEv.c(this.giN);
        return new a(this.iEv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar == null || aVar.iEx == null) {
            return null;
        }
        aVar.iEx.a(iVar);
        return aVar.getView();
    }

    /* loaded from: classes18.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.a iEx;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.iEx = aVar;
        }
    }
}
