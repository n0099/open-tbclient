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
public class k extends com.baidu.adp.widget.ListView.a<q, com.baidu.tieba.card.a.a<t>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), q.bVX);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        t tVar = new t(this.mPageContext);
        tVar.u("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, q qVar, com.baidu.tieba.card.a.a aVar) {
        aVar.aaJ().a((com.baidu.tieba.card.a) qVar);
        aVar.aaJ().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        u.aaj().a(new ak("c10718").ac("obj_id", String.valueOf(qVar.bVY)));
        return aVar.getView();
    }
}
