package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId bdE;
    private com.baidu.tieba.card.j evE;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.ewL);
        this.mPageContext = tbPageContext;
        this.evE = new com.baidu.tieba.card.j(this.mPageContext);
        this.evE.k("c10714", "c10739", "c10712", "c10738");
        this.evE.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bdE = bdUniqueId;
        if (this.evE != null) {
            this.evE.h(this.bdE);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aqe() == null) {
            return null;
        }
        aVar.aqe().a(bVar);
        v.apD().a(new am("c10714").aA("obj_param3", o.apu()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.evE == null) {
            this.evE = new com.baidu.tieba.card.j(this.mPageContext);
            this.evE.h(this.bdE);
            this.evE.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.evE);
    }

    public void onChangeSkinType(int i) {
        if (this.evE != null) {
            this.evE.d(this.mPageContext, i);
        }
    }
}
