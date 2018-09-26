package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId aUU;
    private com.baidu.tieba.card.j efw;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.egD);
        this.mPageContext = tbPageContext;
        this.efw = new com.baidu.tieba.card.j(this.mPageContext);
        this.efw.k("c10714", "c10739", "c10712", "c10738");
        this.efw.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aUU = bdUniqueId;
        if (this.efw != null) {
            this.efw.h(this.aUU);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aln() == null) {
            return null;
        }
        aVar.aln().a(bVar);
        v.akM().a(new am("c10714").al("obj_param3", o.akD()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.efw == null) {
            this.efw = new com.baidu.tieba.card.j(this.mPageContext);
            this.efw.h(this.aUU);
            this.efw.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.efw);
    }

    public void onChangeSkinType(int i) {
        if (this.efw != null) {
            this.efw.d(this.mPageContext, i);
        }
    }
}
