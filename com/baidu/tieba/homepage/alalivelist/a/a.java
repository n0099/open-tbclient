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
    private TbPageContext<?> abz;
    a.InterfaceC0089a cUH;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.abz = null;
        this.cUH = new a.InterfaceC0089a() { // from class: com.baidu.tieba.homepage.alalivelist.a.a.1
            @Override // com.baidu.tieba.homepage.alalivelist.view.a.InterfaceC0089a
            public void a(View view, b bVar) {
            }
        };
        this.abz = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public C0088a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0088a(new com.baidu.tieba.homepage.alalivelist.view.a(this.abz.getPageActivity()));
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
        c0088a.cUJ.a(bVar);
        c0088a.cUJ.setAfterHeadImgOnClickListener(this.cUH);
        c0088a.cUJ.d(this.abz, TbadkCoreApplication.getInst().getSkinType());
        return c0088a.cUJ;
    }

    /* renamed from: com.baidu.tieba.homepage.alalivelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0088a extends j.a {
        public com.baidu.tieba.homepage.alalivelist.view.a cUJ;

        public C0088a(com.baidu.tieba.homepage.alalivelist.view.a aVar) {
            super(aVar);
            this.cUJ = aVar;
        }
    }
}
