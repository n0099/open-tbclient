package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.ad;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.enterForum.square.a.a<o, a> {
    private ad bcx;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext, o.TC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public a b(ViewGroup viewGroup) {
        this.bcx = new ad(this.ND);
        this.bcx.setTag(getTag());
        this.bcx.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_HOT);
        this.bcx.p("c10590", "c10589", "c10588");
        this.bcn = true;
        return new a(this.bcx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, a aVar) {
        if (aVar.bcy == null) {
            return null;
        }
        TiebaStatic.log("c10571");
        if (this.bcn) {
            aVar.bcy.a(oVar);
            this.bcn = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void de(int i) {
        if (this.bcx != null) {
            this.bcx.d(this.ND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ad bcy;

        public a(ad adVar) {
            super(adVar.getView());
            this.bcy = adVar;
        }
    }
}
