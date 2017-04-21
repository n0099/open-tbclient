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
public class a extends com.baidu.adp.widget.ListView.a<c, C0058a> {
    private TbPageContext<?> aaY;
    a.InterfaceC0059a cvx;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aaY = null;
        this.cvx = new b(this);
        this.aaY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public C0058a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0058a(new com.baidu.tieba.homepage.alalivelist.view.a(this.aaY.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, C0058a c0058a) {
        if (c0058a == null || cVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0058a.cvz.a(cVar);
        c0058a.cvz.setAfterHeadImgOnClickListener(this.cvx);
        c0058a.cvz.onChangeSkinType(this.aaY, TbadkCoreApplication.m9getInst().getSkinType());
        return c0058a.cvz;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0058a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cvz;

        public C0058a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cvz = aVar;
        }
    }
}
