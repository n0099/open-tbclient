package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.d, a> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private com.baidu.tieba.homepage.alalivelist.view.e ctn;
    cf<com.baidu.tieba.homepage.alalivelist.view.d> cto;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cto = new e(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ctn = new com.baidu.tieba.homepage.alalivelist.view.e(this.FY);
        this.ctn.i(this.FY.getUniqueId());
        return new a(this.ctn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.d dVar, a aVar) {
        aVar.ctq.onBindDataToView(dVar);
        aVar.ctq.setOnSubCardOnClickListenner(this.cto);
        TiebaStatic.log("c11826");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.e ctq;

        public a(com.baidu.tieba.homepage.alalivelist.view.e eVar) {
            super(eVar.getView());
            this.ctq = eVar;
        }
    }
}
