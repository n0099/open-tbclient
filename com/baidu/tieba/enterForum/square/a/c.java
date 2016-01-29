package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.s;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.enterForum.square.a.a<k, a> {
    private s aXI;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext, k.aRS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public a b(ViewGroup viewGroup) {
        this.aXI = new s(this.Nw);
        this.aXI.setTag(getTag());
        this.aXE = true;
        this.aXI.an("c10580", "c10581");
        return new a(this.aXI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        if (aVar.aXJ == null) {
            return null;
        }
        TiebaStatic.log("c10579");
        if (this.aXE) {
            aVar.aXJ.a(kVar);
            this.aXE = false;
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void db(int i) {
        if (this.aXI != null) {
            this.aXI.d(this.Nw, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public s aXJ;

        public a(s sVar) {
            super(sVar.getView());
            this.aXJ = sVar;
        }
    }
}
