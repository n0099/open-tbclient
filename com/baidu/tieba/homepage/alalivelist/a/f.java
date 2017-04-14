package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.alalivelist.view.h;
import com.baidu.tieba.homepage.alalivelist.view.i;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<h, a> {
    private TbPageContext<?> ajT;
    public BdUniqueId baI;
    cf<h> ctn;
    private i ctq;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ctn = new g(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ctq = new i(this.ajT);
        this.ctq.i(this.ajT.getUniqueId());
        return new a(this.ctq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cts.onBindDataToView(hVar);
        aVar.cts.setOnSubCardOnClickListenner(this.ctn);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public i cts;

        public a(i iVar) {
            super(iVar.getView());
            this.cts = iVar;
        }
    }
}
