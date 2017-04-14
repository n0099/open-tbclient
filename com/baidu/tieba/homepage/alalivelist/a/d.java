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
    private TbPageContext<?> ajT;
    public BdUniqueId baI;
    private com.baidu.tieba.homepage.alalivelist.view.e ctm;
    cf<com.baidu.tieba.homepage.alalivelist.view.d> ctn;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ctn = new e(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ctm = new com.baidu.tieba.homepage.alalivelist.view.e(this.ajT);
        this.ctm.i(this.ajT.getUniqueId());
        return new a(this.ctm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.d dVar, a aVar) {
        aVar.ctp.onBindDataToView(dVar);
        aVar.ctp.setOnSubCardOnClickListenner(this.ctn);
        TiebaStatic.log("c11826");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.e ctp;

        public a(com.baidu.tieba.homepage.alalivelist.view.e eVar) {
            super(eVar.getView());
            this.ctp = eVar;
        }
    }
}
