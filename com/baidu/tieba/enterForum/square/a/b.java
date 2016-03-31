package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cg;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.enterForum.square.a.a<com.baidu.tieba.card.a.e, a> {
    private cg bco;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.card.a.e.TC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public a b(ViewGroup viewGroup) {
        this.bco = Or();
        this.bco.setTag(getTag());
        this.bcn = true;
        this.bco.he("c10583");
        return new a(this.bco);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.e eVar, a aVar) {
        if (aVar.bcp == null) {
            return null;
        }
        TiebaStatic.log("c10582");
        if (this.bcn) {
            aVar.bcp.a(eVar);
            this.bcn = false;
        }
        return aVar.getView();
    }

    private cg Or() {
        cg cgVar = new cg(this.ND);
        cgVar.setAutoScrollIntervalTime(3000L);
        return cgVar;
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onStart() {
        if (this.bco != null) {
            this.bco.xO();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onPause() {
        if (this.bco != null) {
            this.bco.xP();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onDestroy() {
        if (this.bco != null) {
            this.bco.xP();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void de(int i) {
        if (this.bco != null) {
            this.bco.d(this.ND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public cg bcp;

        public a(cg cgVar) {
            super(cgVar.getView());
            this.bcp = cgVar;
        }
    }
}
