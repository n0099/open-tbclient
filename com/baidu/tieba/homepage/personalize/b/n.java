package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.a<q, com.baidu.tieba.card.a.a<t>> {
    private TbPageContext<?> alI;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), q.bKr);
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        t tVar = new t(this.alI);
        tVar.y("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, q qVar, com.baidu.tieba.card.a.a aVar) {
        aVar.Xc().a((com.baidu.tieba.card.a) qVar);
        aVar.Xc().d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        u.WB().a(new aj("c10718").aa("obj_id", String.valueOf(qVar.bKs)));
        return aVar.getView();
    }
}
