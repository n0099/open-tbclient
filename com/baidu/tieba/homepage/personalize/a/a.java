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
    private BdUniqueId bdH;
    private com.baidu.tieba.card.j eyx;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.ezE);
        this.mPageContext = tbPageContext;
        this.eyx = new com.baidu.tieba.card.j(this.mPageContext);
        this.eyx.k("c10714", "c10739", "c10712", "c10738");
        this.eyx.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bdH = bdUniqueId;
        if (this.eyx != null) {
            this.eyx.h(this.bdH);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aqT() == null) {
            return null;
        }
        aVar.aqT().a(bVar);
        v.aqs().a(new am("c10714").aA("obj_param3", o.aqj()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.eyx == null) {
            this.eyx = new com.baidu.tieba.card.j(this.mPageContext);
            this.eyx.h(this.bdH);
            this.eyx.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.eyx);
    }

    public void onChangeSkinType(int i) {
        if (this.eyx != null) {
            this.eyx.d(this.mPageContext, i);
        }
    }
}
