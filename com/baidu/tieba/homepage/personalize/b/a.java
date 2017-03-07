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
    private TbPageContext<?> ajF;
    private BdUniqueId baP;
    private com.baidu.tieba.card.h czl;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cAs);
        this.ajF = tbPageContext;
        this.czl = new com.baidu.tieba.card.h(this.ajF);
        this.czl.k("c10714", "c10739", "c10712", "c10738");
        this.czl.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.baP = bdUniqueId;
        if (this.czl != null) {
            this.czl.i(this.baP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar.Tb() == null) {
            return null;
        }
        aVar.Tb().onBindDataToView(bVar);
        cc.Sv().a(new as("c10714").Z("obj_param3", at.Sp()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.czl == null) {
            this.czl = new com.baidu.tieba.card.h(this.ajF);
            this.czl.i(this.baP);
            this.czl.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.b.a(this.czl);
    }

    public void onChangeSkinType(int i) {
        if (this.czl != null) {
            this.czl.onChangeSkinType(this.ajF, i);
        }
    }
}
