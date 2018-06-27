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
    private BdUniqueId aRF;
    private com.baidu.tieba.card.j dUn;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.dVs);
        this.mPageContext = tbPageContext;
        this.dUn = new com.baidu.tieba.card.j(this.mPageContext);
        this.dUn.k("c10714", "c10739", "c10712", "c10738");
        this.dUn.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aRF = bdUniqueId;
        if (this.dUn != null) {
            this.dUn.h(this.aRF);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aja() == null) {
            return null;
        }
        aVar.aja().a(bVar);
        v.aiz().a(new an("c10714").ah("obj_param3", o.aiq()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dUn == null) {
            this.dUn = new com.baidu.tieba.card.j(this.mPageContext);
            this.dUn.h(this.aRF);
            this.dUn.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dUn);
    }

    public void onChangeSkinType(int i) {
        if (this.dUn != null) {
            this.dUn.d(this.mPageContext, i);
        }
    }
}
