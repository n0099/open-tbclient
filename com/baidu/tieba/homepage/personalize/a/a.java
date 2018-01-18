package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId bGw;
    private com.baidu.tieba.card.e efd;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.efQ);
        this.mPageContext = tbPageContext;
        this.efd = new com.baidu.tieba.card.e(this.mPageContext);
        this.efd.k("c10714", "c10739", "c10712", "c10738");
        this.efd.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGw = bdUniqueId;
        if (this.efd != null) {
            this.efd.h(this.bGw);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.alk() == null) {
            return null;
        }
        aVar.alk().a(bVar);
        s.akF().a(new ak("c10714").ab("obj_param3", com.baidu.tieba.card.k.aks()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.efd == null) {
            this.efd = new com.baidu.tieba.card.e(this.mPageContext);
            this.efd.h(this.bGw);
            this.efd.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.efd);
    }

    public void onChangeSkinType(int i) {
        if (this.efd != null) {
            this.efd.d(this.mPageContext, i);
        }
    }
}
