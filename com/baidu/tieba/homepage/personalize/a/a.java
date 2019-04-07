package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId cnZ;
    private com.baidu.tieba.card.i fLz;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.fNb);
        this.mPageContext = tbPageContext;
        this.fLz = new com.baidu.tieba.card.i(this.mPageContext);
        this.fLz.o("c10714", "c10739", "c10712", "c10738");
        this.fLz.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cnZ = bdUniqueId;
        if (this.fLz != null) {
            this.fLz.i(this.cnZ);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aRg() == null) {
            return null;
        }
        aVar.aRg().a(bVar);
        com.baidu.tieba.card.t.aQD().b(new am("c10714").bJ("obj_param3", com.baidu.tieba.card.n.aQv()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.fLz == null) {
            this.fLz = new com.baidu.tieba.card.i(this.mPageContext);
            this.fLz.i(this.cnZ);
            this.fLz.o("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.fLz);
    }

    public void onChangeSkinType(int i) {
        if (this.fLz != null) {
            this.fLz.onChangeSkinType(this.mPageContext, i);
        }
    }
}
