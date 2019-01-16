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
    private BdUniqueId bes;
    private com.baidu.tieba.card.j ezh;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.eAo);
        this.mPageContext = tbPageContext;
        this.ezh = new com.baidu.tieba.card.j(this.mPageContext);
        this.ezh.k("c10714", "c10739", "c10712", "c10738");
        this.ezh.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bes = bdUniqueId;
        if (this.ezh != null) {
            this.ezh.h(this.bes);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.arr() == null) {
            return null;
        }
        aVar.arr().a(bVar);
        v.aqP().a(new am("c10714").aB("obj_param3", o.aqG()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.ezh == null) {
            this.ezh = new com.baidu.tieba.card.j(this.mPageContext);
            this.ezh.h(this.bes);
            this.ezh.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.ezh);
    }

    public void onChangeSkinType(int i) {
        if (this.ezh != null) {
            this.ezh.d(this.mPageContext, i);
        }
    }
}
