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
public class a extends com.baidu.adp.widget.ListView.a<c, C0061a> {
    private TbPageContext<?> aas;
    a.InterfaceC0062a cyP;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aas = null;
        this.cyP = new b(this);
        this.aas = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public C0061a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0061a(new com.baidu.tieba.homepage.alalivelist.view.a(this.aas.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, c cVar, C0061a c0061a) {
        if (c0061a == null || cVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0061a.cyR.a(cVar);
        c0061a.cyR.setAfterHeadImgOnClickListener(this.cyP);
        c0061a.cyR.d(this.aas, TbadkCoreApplication.m9getInst().getSkinType());
        return c0061a.cyR;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0061a extends z.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cyR;

        public C0061a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cyR = aVar;
        }
    }
}
