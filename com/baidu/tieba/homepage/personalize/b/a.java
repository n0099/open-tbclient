package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aOM;
    private TbPageContext<?> alI;
    private com.baidu.tieba.card.e cTD;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cUG);
        this.alI = tbPageContext;
        this.cTD = new com.baidu.tieba.card.e(this.alI);
        this.cTD.k("c10714", "c10739", "c10712", "c10738");
        this.cTD.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOM = bdUniqueId;
        if (this.cTD != null) {
            this.cTD.i(this.aOM);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.Xc() == null) {
            return null;
        }
        aVar.Xc().a((com.baidu.tieba.card.a) bVar);
        u.WB().a(new aj("c10714").aa("obj_param3", com.baidu.tieba.card.m.Ws()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cTD == null) {
            this.cTD = new com.baidu.tieba.card.e(this.alI);
            this.cTD.i(this.aOM);
            this.cTD.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.cTD);
    }

    public void onChangeSkinType(int i) {
        if (this.cTD != null) {
            this.cTD.d(this.alI, i);
        }
    }
}
