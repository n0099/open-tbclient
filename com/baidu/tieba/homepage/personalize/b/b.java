package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, a> {
    private n dVN;
    private final TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dVN = new n() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                TiebaStatic.log(new an("c11273"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
            }
        };
        this.mPageContext = tbPageContext;
        setOnAdapterItemClickListener(this.dVN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.homepage.personalize.b.a(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        v.aiz().a(new an("c11272"));
        aVar.dVP.a(cVar);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.personalize.b.a dVP;

        public a(com.baidu.tieba.homepage.personalize.b.a aVar) {
            super(aVar.getView());
            this.dVP = aVar;
        }
    }
}
