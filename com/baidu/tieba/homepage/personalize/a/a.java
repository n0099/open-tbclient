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
    private BdUniqueId aPq;
    private com.baidu.tieba.card.e dhr;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.dib);
        this.mPageContext = tbPageContext;
        this.dhr = new com.baidu.tieba.card.e(this.mPageContext);
        this.dhr.i("c10714", "c10739", "c10712", "c10738");
        this.dhr.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPq = bdUniqueId;
        if (this.dhr != null) {
            this.dhr.h(this.aPq);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aax() == null) {
            return null;
        }
        aVar.aax().a((com.baidu.tieba.card.a) bVar);
        u.ZX().a(new ak("c10714").ac("obj_param3", m.ZM()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dhr == null) {
            this.dhr = new com.baidu.tieba.card.e(this.mPageContext);
            this.dhr.h(this.aPq);
            this.dhr.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dhr);
    }

    public void onChangeSkinType(int i) {
        if (this.dhr != null) {
            this.dhr.d(this.mPageContext, i);
        }
    }
}
