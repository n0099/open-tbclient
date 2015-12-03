package com.baidu.tieba.homepage.listview.card.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.homepage.listview.a<d, e> {
    private com.baidu.tbadk.core.view.viewpager.a.b bxY;
    private CustomMessageListener bzQ;
    private CustomMessageListener bzR;
    private TbPageContext<?> pageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bzQ = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.bzR = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.pageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public e a(ViewGroup viewGroup) {
        this.pageContext.registerListener(this.bzQ);
        this.pageContext.registerListener(this.bzR);
        e eVar = new e(this.pageContext, com.baidu.tieba.homepage.fragment.a.b.h(this.pageContext.getPageActivity(), com.baidu.tieba.homepage.fragment.a.b.a(this.pageContext.getPageActivity(), d.class)));
        this.bxY = eVar.bxY;
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, d dVar, e eVar) {
        if (dVar == null) {
            return null;
        }
        if (this.aRB) {
            eVar.c(dVar);
            this.aRB = false;
        }
        eVar.cZ(TbadkCoreApplication.m411getInst().getSkinType());
        return eVar.getView();
    }
}
