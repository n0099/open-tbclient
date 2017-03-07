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
    private TbPageContext<?> ajF;
    public BdUniqueId baP;
    cf<h> cuN;
    private i cuQ;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cuN = new g(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cuQ = new i(this.ajF);
        this.cuQ.i(this.ajF.getUniqueId());
        return new a(this.cuQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cuS.onBindDataToView(hVar);
        aVar.cuS.setOnSubCardOnClickListenner(this.cuN);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public i cuS;

        public a(i iVar) {
            super(iVar.getView());
            this.cuS = iVar;
        }
    }
}
