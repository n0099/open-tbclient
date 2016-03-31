package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.w;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.enterForum.square.a.a<m, a> {
    private w bcu;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext, m.TC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public a b(ViewGroup viewGroup) {
        this.bcu = new w(this.ND);
        this.bcu.setTag(getTag());
        this.bcn = true;
        this.bcu.at("c10573", "c10574");
        return new a(this.bcu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, a aVar) {
        if (aVar.bcv == null) {
            return null;
        }
        TiebaStatic.log("c10572");
        if (this.bcn) {
            aVar.bcv.a(mVar);
            this.bcn = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void de(int i) {
        if (this.bcu != null) {
            this.bcu.d(this.ND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public w bcv;

        public a(w wVar) {
            super(wVar.getView());
            this.bcv = wVar;
        }
    }
}
