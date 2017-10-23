package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.a<q, com.baidu.tieba.card.a.a<t>> {
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), q.bOf);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        t tVar = new t(this.mH);
        tVar.z("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, q qVar, com.baidu.tieba.card.a.a aVar) {
        aVar.Yn().a((com.baidu.tieba.card.a) qVar);
        aVar.Yn().d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        u.XN().a(new ak("c10718").ac("obj_id", String.valueOf(qVar.bOg)));
        return aVar.getView();
    }
}
