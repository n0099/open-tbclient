package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.s;
/* loaded from: classes2.dex */
public class j extends com.baidu.adp.widget.ListView.a<q, com.baidu.tieba.card.a.a<r>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), q.cTq);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.mPageContext);
        rVar.y("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(rVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, q qVar, com.baidu.tieba.card.a.a aVar) {
        aVar.akh().a(qVar);
        aVar.akh().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        s.ajC().a(new ak("c10718").ab("obj_id", String.valueOf(qVar.cTr)));
        return aVar.getView();
    }
}
