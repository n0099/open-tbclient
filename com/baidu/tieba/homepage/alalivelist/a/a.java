package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.homepage.alalivelist.view.a;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<c, C0063a> {
    private TbPageContext<?> aat;
    a.InterfaceC0064a csx;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aat = null;
        this.csx = new b(this);
        this.aat = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public C0063a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0063a(new com.baidu.tieba.homepage.alalivelist.view.a(this.aat.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, C0063a c0063a) {
        if (c0063a == null || cVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0063a.csz.a(cVar);
        c0063a.csz.setAfterHeadImgOnClickListener(this.csx);
        c0063a.csz.onChangeSkinType(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        return c0063a.csz;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0063a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.a csz;

        public C0063a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.csz = aVar;
        }
    }
}
