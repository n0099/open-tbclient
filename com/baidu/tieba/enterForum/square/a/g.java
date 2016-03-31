package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.s;
import com.baidu.tieba.card.ak;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.enterForum.square.a.a<s, a> {
    private ak bcD;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext, s.aVQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public a b(ViewGroup viewGroup) {
        this.bcD = new ak(this.ND);
        this.bcD.setTag(getTag());
        this.bcn = true;
        this.bcD.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_TOP);
        this.bcD.p("c10569", "c10568", "c10567");
        return new a(this.bcD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        if (aVar.bcE == null) {
            return null;
        }
        TiebaStatic.log("c10570");
        if (this.bcn) {
            aVar.bcE.a(sVar);
            this.bcn = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void de(int i) {
        if (this.bcD != null) {
            this.bcD.d(this.ND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ak bcE;

        public a(ak akVar) {
            super(akVar.getView());
            this.bcE = akVar;
        }
    }
}
