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
public class a extends com.baidu.adp.widget.ListView.a<c, C0060a> {
    private TbPageContext<?> Fp;
    a.InterfaceC0061a cth;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Fp = null;
        this.cth = new b(this);
        this.Fp = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public C0060a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0060a(new com.baidu.tieba.homepage.alalivelist.view.a(this.Fp.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, C0060a c0060a) {
        if (c0060a == null || cVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0060a.ctj.a(cVar);
        c0060a.ctj.setAfterHeadImgOnClickListener(this.cth);
        c0060a.ctj.onChangeSkinType(this.Fp, TbadkCoreApplication.m9getInst().getSkinType());
        return c0060a.ctj;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a extends y.a {
        public com.baidu.tieba.homepage.alalivelist.view.a ctj;

        public C0060a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.ctj = aVar;
        }
    }
}
