package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.ac;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.enterForum.square.a.a<o, a> {
    private ac aXR;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext, o.aSg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public a b(ViewGroup viewGroup) {
        this.aXR = new ac(this.Nw);
        this.aXR.setTag(getTag());
        this.aXE = true;
        this.aXR.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND);
        this.aXR.n("c10578", "c10577", "c10576");
        return new a(this.aXR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, a aVar) {
        if (aVar.aXS == null) {
            return null;
        }
        TiebaStatic.log("c10575");
        if (this.aXE) {
            aVar.aXS.a(oVar);
            this.aXE = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void db(int i) {
        if (this.aXR != null) {
            this.aXR.d(this.Nw, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ac aXS;

        public a(ac acVar) {
            super(acVar.getView());
            this.aXS = acVar;
        }
    }
}
