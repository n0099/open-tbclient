package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aPy;
    private com.baidu.tieba.card.e dhL;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.div);
        this.mPageContext = tbPageContext;
        this.dhL = new com.baidu.tieba.card.e(this.mPageContext);
        this.dhL.i("c10714", "c10739", "c10712", "c10738");
        this.dhL.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPy = bdUniqueId;
        if (this.dhL != null) {
            this.dhL.h(this.aPy);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aaJ() == null) {
            return null;
        }
        aVar.aaJ().a((com.baidu.tieba.card.a) bVar);
        u.aaj().a(new ak("c10714").ac("obj_param3", m.ZY()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dhL == null) {
            this.dhL = new com.baidu.tieba.card.e(this.mPageContext);
            this.dhL.h(this.aPy);
            this.dhL.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dhL);
    }

    public void onChangeSkinType(int i) {
        if (this.dhL != null) {
            this.dhL.d(this.mPageContext, i);
        }
    }
}
