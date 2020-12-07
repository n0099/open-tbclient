package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.c, am<com.baidu.tieba.homepage.concern.a.c>> implements com.baidu.tieba.a.f {
    private String aiw;
    private com.baidu.adp.widget.ListView.v amH;
    public BdUniqueId fzO;
    private byte jLh;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.jLh = b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.homepage.concern.a.c> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.b(this.mPageContext, this.fzO, this.jLh));
        aVar.tY().bB(0);
        aVar.tY().bD(0);
        aVar.tY().bC(0);
        aVar.tY().bz(0);
        am<com.baidu.tieba.homepage.concern.a.c> amVar = new am<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amH));
        amVar.setPageId(this.fzO);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.c cVar, am<com.baidu.tieba.homepage.concern.a.c> amVar) {
        amVar.b((am<com.baidu.tieba.homepage.concern.a.c>) cVar);
        if (amVar.tZ() != null) {
            amVar.tZ().setPosition(i);
            amVar.tZ().setPage(this.aiw);
            amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }
}
