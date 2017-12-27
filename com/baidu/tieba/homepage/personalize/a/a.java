package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId bGo;
    private com.baidu.tieba.card.e edP;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.eeB);
        this.mPageContext = tbPageContext;
        this.edP = new com.baidu.tieba.card.e(this.mPageContext);
        this.edP.k("c10714", "c10739", "c10712", "c10738");
        this.edP.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGo = bdUniqueId;
        if (this.edP != null) {
            this.edP.h(this.bGo);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.akh() == null) {
            return null;
        }
        aVar.akh().a(bVar);
        s.ajC().a(new ak("c10714").ab("obj_param3", com.baidu.tieba.card.k.ajp()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.edP == null) {
            this.edP = new com.baidu.tieba.card.e(this.mPageContext);
            this.edP.h(this.bGo);
            this.edP.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.edP);
    }

    public void onChangeSkinType(int i) {
        if (this.edP != null) {
            this.edP.d(this.mPageContext, i);
        }
    }
}
