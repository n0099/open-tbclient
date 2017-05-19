package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.d, a> {
    public BdUniqueId aLk;
    private TbPageContext<?> ajr;
    private com.baidu.tieba.homepage.alalivelist.view.e csD;
    cd<com.baidu.tieba.homepage.alalivelist.view.d> csE;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.csE = new e(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.csD = new com.baidu.tieba.homepage.alalivelist.view.e(this.ajr);
        this.csD.i(this.ajr.getUniqueId());
        return new a(this.csD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.d dVar, a aVar) {
        aVar.csG.onBindDataToView(dVar);
        aVar.csG.setOnSubCardOnClickListenner(this.csE);
        int i2 = 0;
        if (dVar != null && dVar.bcB != null) {
            i2 = dVar.bcB.rQ().live_type;
        }
        TiebaStatic.log(new as("c11826").s("obj_type", i2));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.e csG;

        public a(com.baidu.tieba.homepage.alalivelist.view.e eVar) {
            super(eVar.getView());
            this.csG = eVar;
        }
    }
}
