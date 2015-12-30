package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.enterForum.square.a.a<l, a> {
    private v aVE;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext, l.aQb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public a a(ViewGroup viewGroup) {
        this.aVE = new v(this.mPageContext);
        this.aVE.setTag(getTag());
        this.aVr = true;
        this.aVE.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND);
        this.aVE.n("c10578", "c10577", "c10576");
        return new a(this.aVE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (aVar.aVF == null) {
            return null;
        }
        TiebaStatic.log("c10575");
        if (this.aVr) {
            aVar.aVF.a(lVar);
            this.aVr = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cK(int i) {
        if (this.aVE != null) {
            this.aVE.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public v aVF;

        public a(v vVar) {
            super(vVar.getView());
            this.aVF = vVar;
        }
    }
}
