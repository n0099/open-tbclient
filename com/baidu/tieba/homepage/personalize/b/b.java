package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.s;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, a> {
    private z ivy;
    private final TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ivy = new z() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                TiebaStatic.log(new ao("c11273"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            }
        };
        this.mPageContext = tbPageContext;
        a(this.ivy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public a b(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.homepage.personalize.b.a(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        s.bOA().e(new ao("c11272"));
        aVar.ivA.a(cVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        public com.baidu.tieba.homepage.personalize.b.a ivA;

        public a(com.baidu.tieba.homepage.personalize.b.a aVar) {
            super(aVar.getView());
            this.ivA = aVar;
        }
    }
}
