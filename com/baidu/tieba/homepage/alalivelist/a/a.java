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
public class a extends com.baidu.adp.widget.ListView.a<b, C0088a> {
    private TbPageContext<?> abm;
    a.InterfaceC0089a cUv;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.abm = null;
        this.cUv = new a.InterfaceC0089a() { // from class: com.baidu.tieba.homepage.alalivelist.a.a.1
            @Override // com.baidu.tieba.homepage.alalivelist.view.a.InterfaceC0089a
            public void a(View view, b bVar) {
            }
        };
        this.abm = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public C0088a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0088a(new com.baidu.tieba.homepage.alalivelist.view.a(this.abm.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, C0088a c0088a) {
        if (c0088a == null || bVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0088a.cUx.a(bVar);
        c0088a.cUx.setAfterHeadImgOnClickListener(this.cUv);
        c0088a.cUx.d(this.abm, TbadkCoreApplication.getInst().getSkinType());
        return c0088a.cUx;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0088a extends j.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cUx;

        public C0088a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cUx = aVar;
        }
    }
}
