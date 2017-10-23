package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aPk;
    private com.baidu.tieba.card.e cZb;
    private TbPageContext<?> mH;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.daf);
        this.mH = tbPageContext;
        this.cZb = new com.baidu.tieba.card.e(this.mH);
        this.cZb.i("c10714", "c10739", "c10712", "c10738");
        this.cZb.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPk = bdUniqueId;
        if (this.cZb != null) {
            this.cZb.h(this.aPk);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.Yn() == null) {
            return null;
        }
        aVar.Yn().a((com.baidu.tieba.card.a) bVar);
        u.XN().a(new ak("c10714").ac("obj_param3", com.baidu.tieba.card.m.XC()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cZb == null) {
            this.cZb = new com.baidu.tieba.card.e(this.mH);
            this.cZb.h(this.aPk);
            this.cZb.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.cZb);
    }

    public void onChangeSkinType(int i) {
        if (this.cZb != null) {
            this.cZb.d(this.mH, i);
        }
    }
}
