package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cc;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.b.a<com.baidu.tieba.card.h>> {
    private TbPageContext<?> ajT;
    private BdUniqueId baI;
    private com.baidu.tieba.card.h cxL;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cyS);
        this.ajT = tbPageContext;
        this.cxL = new com.baidu.tieba.card.h(this.ajT);
        this.cxL.k("c10714", "c10739", "c10712", "c10738");
        this.cxL.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.baI = bdUniqueId;
        if (this.cxL != null) {
            this.cxL.i(this.baI);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar.Tz() == null) {
            return null;
        }
        aVar.Tz().onBindDataToView(bVar);
        cc.ST().a(new as("c10714").aa("obj_param3", at.SN()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cxL == null) {
            this.cxL = new com.baidu.tieba.card.h(this.ajT);
            this.cxL.i(this.baI);
            this.cxL.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.b.a(this.cxL);
    }

    public void onChangeSkinType(int i) {
        if (this.cxL != null) {
            this.cxL.onChangeSkinType(this.ajT, i);
        }
    }
}
