package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0063a> {
    private TbPageContext<?> Gd;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Gd = null;
        this.Gd = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public C0063a a(ViewGroup viewGroup) {
        return new C0063a(new com.baidu.tieba.homepage.mygod.b.a(this.Gd));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0063a c0063a) {
        if (c0063a != null) {
            c0063a.cEt.onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
            c0063a.cEt.onBindDataToView(aVar);
            return c0063a.cEt.getView();
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0063a extends y.a {
        public com.baidu.tieba.homepage.mygod.b.a cEt;

        public C0063a(com.baidu.tieba.homepage.mygod.b.a aVar) {
            super(aVar.getView());
            this.cEt = aVar;
        }
    }
}
