package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.data.o;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class j extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.card.a.a<u>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), o.csG);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        u uVar = new u(this.mPageContext);
        uVar.y("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(uVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o oVar, com.baidu.tieba.card.a.a aVar) {
        aVar.afY().a(oVar);
        aVar.afY().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.afy().a(new al("c10718").ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(oVar.csH)));
        return aVar.getView();
    }
}
