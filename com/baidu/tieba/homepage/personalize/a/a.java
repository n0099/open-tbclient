package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aSv;
    private com.baidu.tieba.card.e dqA;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.drm);
        this.mPageContext = tbPageContext;
        this.dqA = new com.baidu.tieba.card.e(this.mPageContext);
        this.dqA.i("c10714", "c10739", "c10712", "c10738");
        this.dqA.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSv = bdUniqueId;
        if (this.dqA != null) {
            this.dqA.h(this.aSv);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.acs() == null) {
            return null;
        }
        aVar.acs().a(bVar);
        s.abU().a(new ak("c10714").ac("obj_param3", com.baidu.tieba.card.k.abH()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dqA == null) {
            this.dqA = new com.baidu.tieba.card.e(this.mPageContext);
            this.dqA.h(this.aSv);
            this.dqA.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dqA);
    }

    public void onChangeSkinType(int i) {
        if (this.dqA != null) {
            this.dqA.d(this.mPageContext, i);
        }
    }
}
