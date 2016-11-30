package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0062a> {
    private TbPageContext<?> Gf;
    public BdUniqueId bcf;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Gf = null;
        this.bcf = null;
        this.Gf = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public C0062a a(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.mygod.b.a aVar = new com.baidu.tieba.homepage.mygod.b.a(this.Gf);
        aVar.i(this.bcf);
        return new C0062a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0062a c0062a) {
        if (c0062a != null) {
            c0062a.cJG.onChangeSkinType(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
            c0062a.cJG.onBindDataToView(aVar);
            return c0062a.cJG.getView();
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a extends y.a {
        public com.baidu.tieba.homepage.mygod.b.a cJG;

        public C0062a(com.baidu.tieba.homepage.mygod.b.a aVar) {
            super(aVar.getView());
            this.cJG = aVar;
        }
    }
}
