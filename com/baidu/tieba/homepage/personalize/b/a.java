package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.ca;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.b.a<com.baidu.tieba.card.d>> {
    private BdUniqueId aLk;
    private TbPageContext<?> ajr;
    private com.baidu.tieba.card.d cvm;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cwq);
        this.ajr = tbPageContext;
        this.cvm = new com.baidu.tieba.card.d(this.ajr);
        this.cvm.k("c10714", "c10739", "c10712", "c10738");
        this.cvm.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aLk = bdUniqueId;
        if (this.cvm != null) {
            this.cvm.i(this.aLk);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar.TU() == null) {
            return null;
        }
        aVar.TU().onBindDataToView(bVar);
        ca.To().a(new as("c10714").aa("obj_param3", ap.Th()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cvm == null) {
            this.cvm = new com.baidu.tieba.card.d(this.ajr);
            this.cvm.i(this.aLk);
            this.cvm.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.b.a(this.cvm);
    }

    public void onChangeSkinType(int i) {
        if (this.cvm != null) {
            this.cvm.onChangeSkinType(this.ajr, i);
        }
    }
}
