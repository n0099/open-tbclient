package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.card.ae;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.enterForum.square.a.a<p, a> {
    private ae bcA;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext, p.aVP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public a b(ViewGroup viewGroup) {
        this.bcA = new ae(this.ND);
        this.bcA.setTag(getTag());
        this.bcn = true;
        this.bcA.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND);
        this.bcA.p("c10578", "c10577", "c10576");
        return new a(this.bcA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, a aVar) {
        if (aVar.bcB == null) {
            return null;
        }
        TiebaStatic.log("c10575");
        if (this.bcn) {
            aVar.bcB.a(pVar);
            this.bcn = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void de(int i) {
        if (this.bcA != null) {
            this.bcA.d(this.ND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ae bcB;

        public a(ae aeVar) {
            super(aeVar.getView());
            this.bcB = aeVar;
        }
    }
}
