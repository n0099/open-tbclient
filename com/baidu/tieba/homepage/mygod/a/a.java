package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.mygod.data.a, C0062a> {
    private TbPageContext<?> Fp;
    public BdUniqueId aUC;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Fp = null;
        this.aUC = null;
        this.Fp = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public C0062a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.mygod.b.a aVar = new com.baidu.tieba.homepage.mygod.b.a(this.Fp);
        aVar.i(this.aUC);
        return new C0062a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.mygod.data.a aVar, C0062a c0062a) {
        if (c0062a != null) {
            c0062a.cwd.onChangeSkinType(this.Fp, TbadkCoreApplication.m9getInst().getSkinType());
            c0062a.cwd.onBindDataToView(aVar);
            return c0062a.cwd.getView();
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.homepage.mygod.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a extends y.a {
        public com.baidu.tieba.homepage.mygod.b.a cwd;

        public C0062a(com.baidu.tieba.homepage.mygod.b.a aVar) {
            super(aVar.getView());
            this.cwd = aVar;
        }
    }
}
