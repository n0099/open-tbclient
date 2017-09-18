package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.x;
import com.baidu.tieba.homepage.alalivelist.view.e;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.d, a> {
    public BdUniqueId aOu;
    x<com.baidu.tieba.homepage.alalivelist.view.d> cYw;
    private e cYz;
    private TbPageContext<?> mF;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cYw = new x<com.baidu.tieba.homepage.alalivelist.view.d>() { // from class: com.baidu.tieba.homepage.alalivelist.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.alalivelist.view.d dVar) {
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cYz = new e(this.mF);
        this.cYz.i(this.aOu);
        return new a(this.cYz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.d dVar, a aVar) {
        aVar.cYB.a(dVar);
        aVar.cYB.b(this.cYw);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.a {
        public e cYB;

        public a(e eVar) {
            super(eVar.getView());
            this.cYB = eVar;
        }
    }
}
