package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.enterForum.square.a.a<k, a> {
    private u aVB;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext, k.aPP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public a a(ViewGroup viewGroup) {
        this.aVB = new u(this.mPageContext);
        this.aVB.setTag(getTag());
        this.aVB.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_HOT);
        this.aVB.n("c10590", "c10589", "c10588");
        this.aVr = true;
        return new a(this.aVB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        if (aVar.aVC == null) {
            return null;
        }
        TiebaStatic.log("c10571");
        if (this.aVr) {
            aVar.aVC.a(kVar);
            this.aVr = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cK(int i) {
        if (this.aVB != null) {
            this.aVB.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public u aVC;

        public a(u uVar) {
            super(uVar.getView());
            this.aVC = uVar;
        }
    }
}
