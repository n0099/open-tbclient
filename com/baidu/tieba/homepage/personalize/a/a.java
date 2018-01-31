package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId bGE;
    private com.baidu.tieba.card.e efy;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.egl);
        this.mPageContext = tbPageContext;
        this.efy = new com.baidu.tieba.card.e(this.mPageContext);
        this.efy.k("c10714", "c10739", "c10712", "c10738");
        this.efy.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGE = bdUniqueId;
        if (this.efy != null) {
            this.efy.h(this.bGE);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.alp() == null) {
            return null;
        }
        aVar.alp().a(bVar);
        s.akK().a(new ak("c10714").aa("obj_param3", com.baidu.tieba.card.k.akx()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.efy == null) {
            this.efy = new com.baidu.tieba.card.e(this.mPageContext);
            this.efy.h(this.bGE);
            this.efy.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.efy);
    }

    public void onChangeSkinType(int i) {
        if (this.efy != null) {
            this.efy.d(this.mPageContext, i);
        }
    }
}
