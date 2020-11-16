package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.c, am<com.baidu.tieba.homepage.concern.a.c>> implements com.baidu.tieba.a.f {
    private String ahw;
    private com.baidu.adp.widget.ListView.v alH;
    public BdUniqueId fsa;
    private byte jxF;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.jxF = b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.homepage.concern.a.c> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.b(this.mPageContext, this.fsa, this.jxF));
        aVar.tV().bx(0);
        aVar.tV().bz(0);
        aVar.tV().by(0);
        aVar.tV().bv(0);
        am<com.baidu.tieba.homepage.concern.a.c> amVar = new am<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.alH));
        amVar.setPageId(this.fsa);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.c cVar, am<com.baidu.tieba.homepage.concern.a.c> amVar) {
        amVar.b((am<com.baidu.tieba.homepage.concern.a.c>) cVar);
        if (amVar.tW() != null) {
            amVar.tW().setPosition(i);
            amVar.tW().setPage(this.ahw);
            amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }
}
