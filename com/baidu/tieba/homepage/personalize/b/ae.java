package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ce;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.q, com.baidu.tieba.card.b.a<ce>> {
    private TbPageContext<?> ajP;

    /* JADX INFO: Access modifiers changed from: protected */
    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.q.bEV);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        ce ceVar = new ce(this.ajP);
        ceVar.x("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.b.a(ceVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.q qVar, com.baidu.tieba.card.b.a aVar) {
        aVar.Wp().a((com.baidu.tieba.card.a) qVar);
        aVar.Wp().d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        cf.VN().a(new au("c10718").Z("obj_id", String.valueOf(qVar.bEW)));
        return aVar.getView();
    }
}
