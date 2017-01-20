package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cc;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.b.a<com.baidu.tieba.card.h>> {
    private TbPageContext<?> FY;
    private BdUniqueId aUC;
    private com.baidu.tieba.card.h cxP;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cyW);
        this.FY = tbPageContext;
        this.cxP = new com.baidu.tieba.card.h(this.FY);
        this.cxP.k("c10714", "c10739", "c10712", "c10738");
        this.cxP.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aUC = bdUniqueId;
        if (this.cxP != null) {
            this.cxP.i(this.aUC);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar.Sd() == null) {
            return null;
        }
        aVar.Sd().onBindDataToView(bVar);
        cc.Rx().a(new ar("c10714").ab("obj_param3", at.Rr()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cxP == null) {
            this.cxP = new com.baidu.tieba.card.h(this.FY);
            this.cxP.i(this.aUC);
            this.cxP.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.b.a(this.cxP);
    }

    public void onChangeSkinType(int i) {
        if (this.cxP != null) {
            this.cxP.onChangeSkinType(this.FY, i);
        }
    }
}
