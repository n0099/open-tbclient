package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aOO;
    private com.baidu.tieba.card.e cVC;
    private TbPageContext<?> oW;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cWF);
        this.oW = tbPageContext;
        this.cVC = new com.baidu.tieba.card.e(this.oW);
        this.cVC.i("c10714", "c10739", "c10712", "c10738");
        this.cVC.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOO = bdUniqueId;
        if (this.cVC != null) {
            this.cVC.i(this.aOO);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.Xv() == null) {
            return null;
        }
        aVar.Xv().a((com.baidu.tieba.card.a) bVar);
        u.WU().a(new aj("c10714").aa("obj_param3", com.baidu.tieba.card.m.WL()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cVC == null) {
            this.cVC = new com.baidu.tieba.card.e(this.oW);
            this.cVC.i(this.aOO);
            this.cVC.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.cVC);
    }

    public void onChangeSkinType(int i) {
        if (this.cVC != null) {
            this.cVC.d(this.oW, i);
        }
    }
}
