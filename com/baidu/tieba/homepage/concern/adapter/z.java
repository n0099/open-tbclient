package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes22.dex */
public class z extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.d, am<com.baidu.tieba.homepage.concern.a.d>> implements com.baidu.tieba.a.f {
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    public BdUniqueId fmX;
    private byte jqR;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.jqR = b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am<com.baidu.tieba.homepage.concern.a.d> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.c(this.mPageContext, this.fmX, this.jqR));
        aVar.tU().bz(0);
        aVar.tU().bB(0);
        aVar.tU().bA(0);
        aVar.tU().bv(0);
        am<com.baidu.tieba.homepage.concern.a.d> amVar = new am<>(aVar.a(true, viewGroup, this.alD));
        amVar.setPageId(this.fmX);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.d dVar, am<com.baidu.tieba.homepage.concern.a.d> amVar) {
        amVar.b((am<com.baidu.tieba.homepage.concern.a.d>) dVar);
        if (amVar.tW() != null) {
            amVar.tW().setPosition(i);
            amVar.tW().setPage(this.ahu);
            amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }
}
