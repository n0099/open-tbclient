package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.homepage.alalivelist.view.a;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<c, C0064a> {
    private TbPageContext<?> aat;
    a.InterfaceC0065a cGB;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aat = null;
        this.cGB = new b(this);
        this.aat = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public C0064a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0064a(new com.baidu.tieba.homepage.alalivelist.view.a(this.aat.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, C0064a c0064a) {
        if (c0064a == null || cVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0064a.cGD.a(cVar);
        c0064a.cGD.setAfterHeadImgOnClickListener(this.cGB);
        c0064a.cGD.d(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        return c0064a.cGD;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0064a extends z.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cGD;

        public C0064a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cGD = aVar;
        }
    }
}
