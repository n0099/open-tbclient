package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.b.a<com.baidu.tieba.card.h>> {
    private BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private com.baidu.tieba.card.h cBE;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cCJ);
        this.ajh = tbPageContext;
        this.cBE = new com.baidu.tieba.card.h(this.ajh);
        this.cBE.l("c10714", "c10739", "c10712", "c10738");
        this.cBE.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aKZ = bdUniqueId;
        if (this.cBE != null) {
            this.cBE.i(this.aKZ);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar.UY() == null) {
            return null;
        }
        aVar.UY().a((com.baidu.tieba.card.a) bVar);
        cf.Uw().a(new as("c10714").Z("obj_param3", at.Up()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cBE == null) {
            this.cBE = new com.baidu.tieba.card.h(this.ajh);
            this.cBE.i(this.aKZ);
            this.cBE.l("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.b.a(this.cBE);
    }

    public void onChangeSkinType(int i) {
        if (this.cBE != null) {
            this.cBE.d(this.ajh, i);
        }
    }
}
