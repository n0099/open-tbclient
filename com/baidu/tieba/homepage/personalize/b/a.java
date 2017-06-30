package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.b.a<com.baidu.tieba.card.h>> {
    private BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private com.baidu.tieba.card.h cJB;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cKH);
        this.ajP = tbPageContext;
        this.cJB = new com.baidu.tieba.card.h(this.ajP);
        this.cJB.k("c10714", "c10739", "c10712", "c10738");
        this.cJB.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aMp = bdUniqueId;
        if (this.cJB != null) {
            this.cJB.i(this.aMp);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a((com.baidu.tieba.card.a) bVar);
        cf.VN().a(new au("c10714").Z("obj_param3", at.VG()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cJB == null) {
            this.cJB = new com.baidu.tieba.card.h(this.ajP);
            this.cJB.i(this.aMp);
            this.cJB.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.b.a(this.cJB);
    }

    public void onChangeSkinType(int i) {
        if (this.cJB != null) {
            this.cJB.d(this.ajP, i);
        }
    }
}
