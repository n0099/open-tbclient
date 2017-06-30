package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.alalivelist.view.h;
import com.baidu.tieba.homepage.alalivelist.view.i;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<h, a> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    ci<h> cGI;
    private i cGL;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cGI = new g(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cGL = new i(this.ajP);
        this.cGL.i(this.ajP.getUniqueId());
        return new a(this.cGL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cGN.a(hVar);
        aVar.cGN.a(this.cGI);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z.a {
        public i cGN;

        public a(i iVar) {
            super(iVar.getView());
            this.cGN = iVar;
        }
    }
}
