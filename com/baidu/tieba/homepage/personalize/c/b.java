package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, a> {
    private x<c> bkE;
    private final TbPageContext<?> oW;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkE = new x<c>() { // from class: com.baidu.tieba.homepage.personalize.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, c cVar) {
                TiebaStatic.log(new aj("c11273"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            }
        };
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.personalize.c.a aVar = new com.baidu.tieba.homepage.personalize.c.a(this.oW);
        aVar.b(this.bkE);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        u.WU().a(new aj("c11272"));
        aVar.cWY.a(cVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.homepage.personalize.c.a cWY;

        public a(com.baidu.tieba.homepage.personalize.c.a aVar) {
            super(aVar.getView());
            this.cWY = aVar;
        }
    }
}
