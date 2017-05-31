package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.d, a> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private com.baidu.tieba.homepage.alalivelist.view.e cyV;
    ci<com.baidu.tieba.homepage.alalivelist.view.d> cyW;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cyW = new e(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cyV = new com.baidu.tieba.homepage.alalivelist.view.e(this.ajh);
        this.cyV.i(this.ajh.getUniqueId());
        return new a(this.cyV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.d dVar, a aVar) {
        aVar.cyY.a(dVar);
        aVar.cyY.a(this.cyW);
        int i2 = 0;
        if (dVar != null && dVar.aYA != null) {
            i2 = dVar.aYA.rM().live_type;
        }
        TiebaStatic.log(new as("c11826").r("obj_type", i2));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z.a {
        public com.baidu.tieba.homepage.alalivelist.view.e cyY;

        public a(com.baidu.tieba.homepage.alalivelist.view.e eVar) {
            super(eVar.getView());
            this.cyY = eVar;
        }
    }
}
