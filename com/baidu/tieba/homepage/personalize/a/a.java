package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId aZt;
    private com.baidu.tieba.card.j enp;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.eox);
        this.mPageContext = tbPageContext;
        this.enp = new com.baidu.tieba.card.j(this.mPageContext);
        this.enp.k("c10714", "c10739", "c10712", "c10738");
        this.enp.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aZt = bdUniqueId;
        if (this.enp != null) {
            this.enp.h(this.aZt);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aoP() == null) {
            return null;
        }
        aVar.aoP().a(bVar);
        v.aoo().a(new am("c10714").ax("obj_param3", o.aof()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.enp == null) {
            this.enp = new com.baidu.tieba.card.j(this.mPageContext);
            this.enp.h(this.aZt);
            this.enp.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.enp);
    }

    public void onChangeSkinType(int i) {
        if (this.enp != null) {
            this.enp.d(this.mPageContext, i);
        }
    }
}
