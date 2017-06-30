package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.d, a> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private com.baidu.tieba.homepage.alalivelist.view.e cGH;
    ci<com.baidu.tieba.homepage.alalivelist.view.d> cGI;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cGI = new e(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cGH = new com.baidu.tieba.homepage.alalivelist.view.e(this.ajP);
        this.cGH.i(this.ajP.getUniqueId());
        return new a(this.cGH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.d dVar, a aVar) {
        aVar.cGK.a(dVar);
        aVar.cGK.a(this.cGI);
        int i2 = 0;
        if (dVar != null && dVar.bai != null) {
            i2 = dVar.bai.rJ().live_type;
        }
        TiebaStatic.log(new au("c11826").r("obj_type", i2));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z.a {
        public com.baidu.tieba.homepage.alalivelist.view.e cGK;

        public a(com.baidu.tieba.homepage.alalivelist.view.e eVar) {
            super(eVar.getView());
            this.cGK = eVar;
        }
    }
}
