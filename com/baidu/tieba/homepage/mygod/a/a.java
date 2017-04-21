package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0060a> {
    private TbPageContext<?> aaY;
    public BdUniqueId bbE;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aaY = null;
        this.bbE = null;
        this.aaY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public C0060a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.mygod.b.a aVar = new com.baidu.tieba.homepage.mygod.b.a(this.aaY);
        aVar.i(this.bbE);
        return new C0060a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0060a c0060a) {
        if (c0060a != null) {
            c0060a.cyt.onChangeSkinType(this.aaY, TbadkCoreApplication.m9getInst().getSkinType());
            c0060a.cyt.onBindDataToView(aVar);
            return c0060a.cyt.getView();
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a extends y.a {
        public com.baidu.tieba.homepage.mygod.b.a cyt;

        public C0060a(com.baidu.tieba.homepage.mygod.b.a aVar) {
            super(aVar.getView());
            this.cyt = aVar;
        }
    }
}
