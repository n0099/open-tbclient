package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.d, C0061a> {
    private TbPageContext<?> Ea;
    private boolean ZM;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.d.aUY);
        this.mSkinType = 3;
        this.ZM = false;
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public C0061a a(ViewGroup viewGroup) {
        return new C0061a(new com.baidu.tieba.card.e(this.Ea));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.d dVar, C0061a c0061a) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.Ea.getLayoutMode().ad(this.mSkinType == 1);
        this.Ea.getLayoutMode().w(view);
        c0061a.cre.d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        c0061a.cre.setFromCDN(this.ZM);
        c0061a.cre.a(dVar);
        return c0061a.getView();
    }

    public void setFromCDN(boolean z) {
        this.ZM = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0061a extends y.a {
        public com.baidu.tieba.card.e cre;

        public C0061a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cre = eVar;
        }
    }
}
