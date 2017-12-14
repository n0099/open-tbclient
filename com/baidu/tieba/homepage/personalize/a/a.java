package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aSy;
    private com.baidu.tieba.card.e drF;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.dsr);
        this.mPageContext = tbPageContext;
        this.drF = new com.baidu.tieba.card.e(this.mPageContext);
        this.drF.h("c10714", "c10739", "c10712", "c10738");
        this.drF.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSy = bdUniqueId;
        if (this.drF != null) {
            this.drF.h(this.aSy);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.acC() == null) {
            return null;
        }
        aVar.acC().a(bVar);
        s.abX().a(new ak("c10714").ac("obj_param3", com.baidu.tieba.card.k.abK()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.drF == null) {
            this.drF = new com.baidu.tieba.card.e(this.mPageContext);
            this.drF.h(this.aSy);
            this.drF.h("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.drF);
    }

    public void onChangeSkinType(int i) {
        if (this.drF != null) {
            this.drF.d(this.mPageContext, i);
        }
    }
}
