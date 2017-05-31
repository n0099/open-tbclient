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
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    ci<h> cyW;
    private i cyZ;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cyW = new g(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cyZ = new i(this.ajh);
        this.cyZ.i(this.ajh.getUniqueId());
        return new a(this.cyZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.czb.a(hVar);
        aVar.czb.a(this.cyW);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z.a {
        public i czb;

        public a(i iVar) {
            super(iVar.getView());
            this.czb = iVar;
        }
    }
}
