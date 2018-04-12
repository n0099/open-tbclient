package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.sina.weibo.sdk.api.CmdObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId aTr;
    private com.baidu.tieba.card.j dEu;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.dFg);
        this.mPageContext = tbPageContext;
        this.dEu = new com.baidu.tieba.card.j(this.mPageContext);
        this.dEu.k("c10714", "c10739", "c10712", "c10738");
        this.dEu.setFrom(CmdObject.CMD_HOME);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTr = bdUniqueId;
        if (this.dEu != null) {
            this.dEu.h(this.aTr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.afY() == null) {
            return null;
        }
        aVar.afY().a(bVar);
        v.afy().a(new al("c10714").ac("obj_param3", o.afp()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dEu == null) {
            this.dEu = new com.baidu.tieba.card.j(this.mPageContext);
            this.dEu.h(this.aTr);
            this.dEu.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dEu);
    }

    public void onChangeSkinType(int i) {
        if (this.dEu != null) {
            this.dEu.d(this.mPageContext, i);
        }
    }
}
