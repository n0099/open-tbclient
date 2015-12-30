package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.enterForum.square.a.a<i, a> {
    private n aVy;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext, i.aPP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public a a(ViewGroup viewGroup) {
        this.aVy = new n(this.mPageContext);
        this.aVy.setTag(getTag());
        this.aVr = true;
        this.aVy.an("c10573", "c10574");
        return new a(this.aVy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        if (aVar.aVz == null) {
            return null;
        }
        TiebaStatic.log("c10572");
        if (this.aVr) {
            aVar.aVz.a(iVar);
            this.aVr = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cK(int i) {
        if (this.aVy != null) {
            this.aVy.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public n aVz;

        public a(n nVar) {
            super(nVar.getView());
            this.aVz = nVar;
        }
    }
}
