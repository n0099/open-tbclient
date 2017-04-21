package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.d, a> {
    private TbPageContext<?> ajU;
    public BdUniqueId bbE;
    private com.baidu.tieba.homepage.alalivelist.view.e cvD;
    cf<com.baidu.tieba.homepage.alalivelist.view.d> cvE;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cvE = new e(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvD = new com.baidu.tieba.homepage.alalivelist.view.e(this.ajU);
        this.cvD.i(this.ajU.getUniqueId());
        return new a(this.cvD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.d dVar, a aVar) {
        aVar.cvG.onBindDataToView(dVar);
        aVar.cvG.setOnSubCardOnClickListenner(this.cvE);
        int i2 = 0;
        if (dVar != null && dVar.bck != null) {
            i2 = dVar.bck.sG().live_type;
        }
        TiebaStatic.log(new as("c11826").s("obj_type", i2));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.e cvG;

        public a(com.baidu.tieba.homepage.alalivelist.view.e eVar) {
            super(eVar.getView());
            this.cvG = eVar;
        }
    }
}
