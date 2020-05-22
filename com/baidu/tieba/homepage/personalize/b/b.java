package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.s;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, a> {
    private x ifz;
    private final TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ifz = new x() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                TiebaStatic.log(new an("c11273"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            }
        };
        this.mPageContext = tbPageContext;
        a(this.ifz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public a b(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.homepage.personalize.b.a(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        s.bLq().e(new an("c11272"));
        aVar.ifB.a(cVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        public com.baidu.tieba.homepage.personalize.b.a ifB;

        public a(com.baidu.tieba.homepage.personalize.b.a aVar) {
            super(aVar.getView());
            this.ifB = aVar;
        }
    }
}
