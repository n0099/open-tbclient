package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0060a> {
    private TbPageContext<?> Gd;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Gd = null;
        this.Gd = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public C0060a a(ViewGroup viewGroup) {
        return new C0060a(new com.baidu.tieba.homepage.mygod.b.a(this.Gd));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0060a c0060a) {
        if (c0060a != null) {
            c0060a.cDP.onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
            c0060a.cDP.onBindDataToView(aVar);
            return c0060a.cDP.getView();
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a extends y.a {
        public com.baidu.tieba.homepage.mygod.b.a cDP;

        public C0060a(com.baidu.tieba.homepage.mygod.b.a aVar) {
            super(aVar.getView());
            this.cDP = aVar;
        }
    }
}
