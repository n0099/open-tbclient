package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.card.ad;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.enterForum.square.a.a<p, a> {
    private ad aXU;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext, p.aSh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public a b(ViewGroup viewGroup) {
        this.aXU = new ad(this.Nw);
        this.aXU.setTag(getTag());
        this.aXE = true;
        this.aXU.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_TOP);
        this.aXU.n("c10569", "c10568", "c10567");
        return new a(this.aXU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, a aVar) {
        if (aVar.aXV == null) {
            return null;
        }
        TiebaStatic.log("c10570");
        if (this.aXE) {
            aVar.aXV.a(pVar);
            this.aXE = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void db(int i) {
        if (this.aXU != null) {
            this.aXU.d(this.Nw, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ad aXV;

        public a(ad adVar) {
            super(adVar.getView());
            this.aXV = adVar;
        }
    }
}
