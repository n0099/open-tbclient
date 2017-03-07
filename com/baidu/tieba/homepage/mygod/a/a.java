package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0061a> {
    private TbPageContext<?> aaI;
    public BdUniqueId baP;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aaI = null;
        this.baP = null;
        this.aaI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public C0061a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.mygod.b.a aVar = new com.baidu.tieba.homepage.mygod.b.a(this.aaI);
        aVar.i(this.baP);
        return new C0061a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0061a c0061a) {
        if (c0061a != null) {
            c0061a.cxC.onChangeSkinType(this.aaI, TbadkCoreApplication.m9getInst().getSkinType());
            c0061a.cxC.onBindDataToView(aVar);
            return c0061a.cxC.getView();
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0061a extends y.a {
        public com.baidu.tieba.homepage.mygod.b.a cxC;

        public C0061a(com.baidu.tieba.homepage.mygod.b.a aVar) {
            super(aVar.getView());
            this.cxC = aVar;
        }
    }
}
