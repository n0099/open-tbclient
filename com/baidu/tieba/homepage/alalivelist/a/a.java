package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.homepage.alalivelist.view.a;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, C0086a> {
    private TbPageContext<?> acp;
    a.InterfaceC0087a cPg;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acp = null;
        this.cPg = new a.InterfaceC0087a() { // from class: com.baidu.tieba.homepage.alalivelist.a.a.1
            @Override // com.baidu.tieba.homepage.alalivelist.view.a.InterfaceC0087a
            public void a(View view, b bVar) {
            }
        };
        this.acp = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public C0086a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0086a(new com.baidu.tieba.homepage.alalivelist.view.a(this.acp.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, C0086a c0086a) {
        if (c0086a == null || bVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0086a.cPi.a(bVar);
        c0086a.cPi.setAfterHeadImgOnClickListener(this.cPg);
        c0086a.cPi.d(this.acp, TbadkCoreApplication.getInst().getSkinType());
        return c0086a.cPi;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0086a extends j.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cPi;

        public C0086a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cPi = aVar;
        }
    }
}
