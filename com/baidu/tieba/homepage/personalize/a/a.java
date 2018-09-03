package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId aRC;
    private com.baidu.tieba.card.j dYc;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.dZh);
        this.mPageContext = tbPageContext;
        this.dYc = new com.baidu.tieba.card.j(this.mPageContext);
        this.dYc.k("c10714", "c10739", "c10712", "c10738");
        this.dYc.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aRC = bdUniqueId;
        if (this.dYc != null) {
            this.dYc.h(this.aRC);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.ajC() == null) {
            return null;
        }
        aVar.ajC().a(bVar);
        v.ajb().a(new an("c10714").ae("obj_param3", o.aiS()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dYc == null) {
            this.dYc = new com.baidu.tieba.card.j(this.mPageContext);
            this.dYc.h(this.aRC);
            this.dYc.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dYc);
    }

    public void onChangeSkinType(int i) {
        if (this.dYc != null) {
            this.dYc.d(this.mPageContext, i);
        }
    }
}
