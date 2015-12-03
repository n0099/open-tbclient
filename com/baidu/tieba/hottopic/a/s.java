package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.j, com.baidu.tbadk.core.view.viewpager.c> {
    private p bCR;
    private com.baidu.tbadk.core.view.viewpager.b bCS;
    private HotTopicActivity bCu;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bCR = new p(hotTopicActivity, RelateForumItemData.TYPE_FORUM_CARD);
        this.bCu = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public com.baidu.tbadk.core.view.viewpager.c a(ViewGroup viewGroup) {
        this.bCS = new com.baidu.tbadk.core.view.viewpager.b(this.bCu.getPageContext().getPageActivity());
        this.bCS.a(this.bCu.getPageContext().getPageActivity(), this.bCR);
        this.bCS.setMaxScrollCountLimit(4);
        this.bCu.a(this.bCS);
        return this.bCS.getViewHolder();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.j jVar, com.baidu.tbadk.core.view.viewpager.c cVar) {
        if (cVar == null || jVar == null || this.bCS == null) {
            return null;
        }
        a(cVar, jVar);
        c(cVar.afY, view);
        return view;
    }

    private void c(int i, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bCS != null) {
            this.bCS.cZ(skinType);
        }
        if (this.bCu != null && i != skinType) {
            this.bCu.getLayoutMode().af(skinType == 1);
            this.bCu.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tbadk.core.view.viewpager.c cVar, com.baidu.tieba.hottopic.data.j jVar) {
        if (cVar != null && jVar != null) {
            cVar.agd.setText(TbadkCoreApplication.m411getInst().getString(n.i.relate_forum_recommend));
            cVar.agg.setVisibility(0);
            if (this.bCS != null) {
                if (jVar.bEx) {
                    this.bCS.setDatas(jVar.bEw);
                    jVar.bEx = false;
                }
                if (jVar.bEy) {
                    this.bCS.notifyDataSetChanged();
                    jVar.bEy = false;
                }
                this.bCS.getMoreView().setOnClickListener(new t(this, jVar));
            }
        }
    }
}
