package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUs;
    private com.baidu.adp.lib.f.b<TbImageView> bUt;
    private cf bWv;
    private al cFC;
    private com.baidu.tieba.homepage.personalize.b.f cFD;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bWv = new f(this);
        this.bUs = new com.baidu.adp.lib.f.b<>(new g(this), 6, 0);
        this.bUt = new com.baidu.adp.lib.f.b<>(new h(this), 12, 0);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public a a(ViewGroup viewGroup) {
        this.cFC = new al(this.GM);
        this.cFC.setConstrainLayoutPool(this.bUs);
        this.cFC.setConstrainImagePool(this.bUt);
        this.cFC.j(this.aYu);
        return new a(this.cFC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gf(i + 1);
        }
        aVar.cFF.a(mVar);
        aVar.cFF.setOnSubCardOnClickListenner(this.bWv);
        if (mVar.threadData != null && mVar.threadData.getTid() != null) {
            cd.NI().b(new ay("c11003").ab("tid", mVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cFC != null) {
            this.cFC.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public al cFF;

        public a(al alVar) {
            super(alVar.getView());
            this.cFF = alVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cFD = fVar;
    }
}
