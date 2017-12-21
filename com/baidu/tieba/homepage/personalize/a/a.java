package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aSB;
    private com.baidu.tieba.card.e drJ;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.dsv);
        this.mPageContext = tbPageContext;
        this.drJ = new com.baidu.tieba.card.e(this.mPageContext);
        this.drJ.h("c10714", "c10739", "c10712", "c10738");
        this.drJ.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSB = bdUniqueId;
        if (this.drJ != null) {
            this.drJ.h(this.aSB);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.acB() == null) {
            return null;
        }
        aVar.acB().a(bVar);
        s.abW().a(new ak("c10714").ac("obj_param3", com.baidu.tieba.card.k.abJ()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.drJ == null) {
            this.drJ = new com.baidu.tieba.card.e(this.mPageContext);
            this.drJ.h(this.aSB);
            this.drJ.h("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.drJ);
    }

    public void onChangeSkinType(int i) {
        if (this.drJ != null) {
            this.drJ.d(this.mPageContext, i);
        }
    }
}
