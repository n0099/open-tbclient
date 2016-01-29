package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.enterForum.square.a.a<l, a> {
    private u aXL;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext, l.aRS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public a b(ViewGroup viewGroup) {
        this.aXL = new u(this.Nw);
        this.aXL.setTag(getTag());
        this.aXE = true;
        this.aXL.an("c10573", "c10574");
        return new a(this.aXL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (aVar.aXM == null) {
            return null;
        }
        TiebaStatic.log("c10572");
        if (this.aXE) {
            aVar.aXM.a(lVar);
            this.aXE = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void db(int i) {
        if (this.aXL != null) {
            this.aXL.d(this.Nw, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public u aXM;

        public a(u uVar) {
            super(uVar.getView());
            this.aXM = uVar;
        }
    }
}
