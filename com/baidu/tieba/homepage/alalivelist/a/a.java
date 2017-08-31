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
public class a extends com.baidu.adp.widget.ListView.a<b, C0089a> {
    private TbPageContext<?> aby;
    a.InterfaceC0090a cXv;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aby = null;
        this.cXv = new a.InterfaceC0090a() { // from class: com.baidu.tieba.homepage.alalivelist.a.a.1
            @Override // com.baidu.tieba.homepage.alalivelist.view.a.InterfaceC0090a
            public void a(View view, b bVar) {
            }
        };
        this.aby = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public C0089a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0089a(new com.baidu.tieba.homepage.alalivelist.view.a(this.aby.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, C0089a c0089a) {
        if (c0089a == null || bVar == null) {
            return null;
        }
        TiebaStatic.log("c11828");
        c0089a.cXx.a(bVar);
        c0089a.cXx.setAfterHeadImgOnClickListener(this.cXv);
        c0089a.cXx.d(this.aby, TbadkCoreApplication.getInst().getSkinType());
        return c0089a.cXx;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0089a extends j.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cXx;

        public C0089a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cXx = aVar;
        }
    }
}
