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
public class a extends com.baidu.adp.widget.ListView.a<b, C0087a> {
    private TbPageContext<?> acr;
    a.InterfaceC0088a cRd;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acr = null;
        this.cRd = new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.alalivelist.a.a.1
            @Override // com.baidu.tieba.homepage.alalivelist.view.a.InterfaceC0088a
            public void a(View view, b bVar) {
            }
        };
        this.acr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public C0087a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0087a(new com.baidu.tieba.homepage.alalivelist.view.a(this.acr.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, C0087a c0087a) {
        if (c0087a == null || bVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0087a.cRf.a(bVar);
        c0087a.cRf.setAfterHeadImgOnClickListener(this.cRd);
        c0087a.cRf.d(this.acr, TbadkCoreApplication.getInst().getSkinType());
        return c0087a.cRf;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0087a extends j.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cRf;

        public C0087a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cRf = aVar;
        }
    }
}
