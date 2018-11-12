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
    private BdUniqueId bag;
    private com.baidu.tieba.card.j eoK;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.epR);
        this.mPageContext = tbPageContext;
        this.eoK = new com.baidu.tieba.card.j(this.mPageContext);
        this.eoK.k("c10714", "c10739", "c10712", "c10738");
        this.eoK.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bag = bdUniqueId;
        if (this.eoK != null) {
            this.eoK.h(this.bag);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aor() == null) {
            return null;
        }
        aVar.aor().a(bVar);
        v.anQ().a(new am("c10714").ax("obj_param3", o.anH()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.eoK == null) {
            this.eoK = new com.baidu.tieba.card.j(this.mPageContext);
            this.eoK.h(this.bag);
            this.eoK.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.eoK);
    }

    public void onChangeSkinType(int i) {
        if (this.eoK != null) {
            this.eoK.d(this.mPageContext, i);
        }
    }
}
