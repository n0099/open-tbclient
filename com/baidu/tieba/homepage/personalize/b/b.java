package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, a> {
    private ab iQw;
    private final TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iQw = new ab() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                TiebaStatic.log(new aq("c11273"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            }
        };
        this.mPageContext = tbPageContext;
        a(this.iQw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public a b(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.homepage.personalize.b.a(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        s.cbX().e(new aq("c11272"));
        aVar.iQy.a(cVar);
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        public com.baidu.tieba.homepage.personalize.b.a iQy;

        public a(com.baidu.tieba.homepage.personalize.b.a aVar) {
            super(aVar.getView());
            this.iQy = aVar;
        }
    }
}
