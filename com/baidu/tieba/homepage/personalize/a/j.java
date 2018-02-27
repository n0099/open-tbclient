package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.card.q;
import com.baidu.tieba.card.r;
/* loaded from: classes2.dex */
public class j extends com.baidu.adp.widget.ListView.a<p, com.baidu.tieba.card.a.a<q>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), p.daO);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        q qVar = new q(this.mPageContext);
        qVar.z("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(qVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, p pVar, com.baidu.tieba.card.a.a aVar) {
        aVar.alX().a(pVar);
        aVar.alX().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        r.als().a(new ak("c10718").ab("obj_id", String.valueOf(pVar.daP)));
        return aVar.getView();
    }
}
