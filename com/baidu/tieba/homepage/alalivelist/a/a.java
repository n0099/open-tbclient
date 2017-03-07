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
public class a extends com.baidu.adp.widget.ListView.a<c, C0059a> {
    private TbPageContext<?> aaI;
    a.InterfaceC0060a cuG;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aaI = null;
        this.cuG = new b(this);
        this.aaI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public C0059a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0059a(new com.baidu.tieba.homepage.alalivelist.view.a(this.aaI.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, C0059a c0059a) {
        if (c0059a == null || cVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0059a.cuI.a(cVar);
        c0059a.cuI.setAfterHeadImgOnClickListener(this.cuG);
        c0059a.cuI.onChangeSkinType(this.aaI, TbadkCoreApplication.m9getInst().getSkinType());
        return c0059a.cuI;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0059a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cuI;

        public C0059a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cuI = aVar;
        }
    }
}
