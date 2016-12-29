package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0060a> {
    private TbPageContext<?> Gf;
    public BdUniqueId bbl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Gf = null;
        this.bbl = null;
        this.Gf = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: T */
    public C0060a a(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.mygod.b.a aVar = new com.baidu.tieba.homepage.mygod.b.a(this.Gf);
        aVar.i(this.bbl);
        return new C0060a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0060a c0060a) {
        if (c0060a != null) {
            c0060a.cpb.onChangeSkinType(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
            c0060a.cpb.onBindDataToView(aVar);
            return c0060a.cpb.getView();
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a extends y.a {
        public com.baidu.tieba.homepage.mygod.b.a cpb;

        public C0060a(com.baidu.tieba.homepage.mygod.b.a aVar) {
            super(aVar.getView());
            this.cpb = aVar;
        }
    }
}
