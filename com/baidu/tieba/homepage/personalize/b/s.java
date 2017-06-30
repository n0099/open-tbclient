package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m>> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private com.baidu.tieba.card.m cJS;
    private ci<com.baidu.tieba.card.data.h> cJT;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.cJT = new t(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cJS = new com.baidu.tieba.card.m(this.ajP, this.aMp);
        return new com.baidu.tieba.card.b.a(this.cJS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m> aVar) {
        this.cJS = aVar.Wp();
        aVar.Wp().a(hVar);
        aVar.Wp().a(this.cJT);
        aVar.Wp().d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        cf.VN().a(new au("c11006"));
        return aVar.getView();
    }

    public void ky(int i) {
        if (this.cJS != null) {
            this.cJS.d(this.ajP, i);
        }
    }
}
