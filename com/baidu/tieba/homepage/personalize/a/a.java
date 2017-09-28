package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aPx;
    private com.baidu.tieba.card.e cZo;
    private TbPageContext<?> mG;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.das);
        this.mG = tbPageContext;
        this.cZo = new com.baidu.tieba.card.e(this.mG);
        this.cZo.i("c10714", "c10739", "c10712", "c10738");
        this.cZo.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPx = bdUniqueId;
        if (this.cZo != null) {
            this.cZo.h(this.aPx);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.Yr() == null) {
            return null;
        }
        aVar.Yr().a((com.baidu.tieba.card.a) bVar);
        u.XR().a(new ak("c10714").ad("obj_param3", com.baidu.tieba.card.m.XG()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cZo == null) {
            this.cZo = new com.baidu.tieba.card.e(this.mG);
            this.cZo.h(this.aPx);
            this.cZo.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.cZo);
    }

    public void onChangeSkinType(int i) {
        if (this.cZo != null) {
            this.cZo.d(this.mG, i);
        }
    }
}
