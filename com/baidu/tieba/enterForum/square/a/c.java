package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.enterForum.square.a.a<l, a> {
    private u bcr;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext, l.TC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public a b(ViewGroup viewGroup) {
        this.bcr = new u(this.ND);
        this.bcr.setTag(getTag());
        this.bcn = true;
        this.bcr.at("c10580", "c10581");
        return new a(this.bcr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (aVar.bcs == null) {
            return null;
        }
        TiebaStatic.log("c10579");
        if (this.bcn) {
            aVar.bcs.a(lVar);
            this.bcn = false;
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void de(int i) {
        if (this.bcr != null) {
            this.bcr.d(this.ND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public u bcs;

        public a(u uVar) {
            super(uVar.getView());
            this.bcs = uVar;
        }
    }
}
