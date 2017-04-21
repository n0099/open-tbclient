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
    private TbPageContext<?> ajU;
    public BdUniqueId bbE;
    cf<h> cvE;
    private i cvH;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cvE = new g(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvH = new i(this.ajU);
        this.cvH.i(this.ajU.getUniqueId());
        return new a(this.cvH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cvJ.onBindDataToView(hVar);
        aVar.cvJ.setOnSubCardOnClickListenner(this.cvE);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public i cvJ;

        public a(i iVar) {
            super(iVar.getView());
            this.cvJ = iVar;
        }
    }
}
