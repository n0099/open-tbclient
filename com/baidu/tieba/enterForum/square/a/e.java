package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.ab;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.enterForum.square.a.a<n, a> {
    private ab aXO;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext, n.aRS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public a b(ViewGroup viewGroup) {
        this.aXO = new ab(this.Nw);
        this.aXO.setTag(getTag());
        this.aXO.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_HOT);
        this.aXO.n("c10590", "c10589", "c10588");
        this.aXE = true;
        return new a(this.aXO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (aVar.aXP == null) {
            return null;
        }
        TiebaStatic.log("c10571");
        if (this.aXE) {
            aVar.aXP.a(nVar);
            this.aXE = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void db(int i) {
        if (this.aXO != null) {
            this.aXO.d(this.Nw, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ab aXP;

        public a(ab abVar) {
            super(abVar.getView());
            this.aXP = abVar;
        }
    }
}
