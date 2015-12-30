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
    private HotTopicActivity bFY;
    private p bGv;
    private com.baidu.tbadk.core.view.viewpager.b bGw;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bGv = new p(hotTopicActivity, RelateForumItemData.TYPE_FORUM_CARD);
        this.bFY = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public com.baidu.tbadk.core.view.viewpager.c a(ViewGroup viewGroup) {
        this.bGw = new com.baidu.tbadk.core.view.viewpager.b(this.bFY.getPageContext().getPageActivity());
        this.bGw.a(this.bFY.getPageContext().getPageActivity(), this.bGv);
        this.bGw.setMaxScrollCountLimit(4);
        this.bFY.a(this.bGw);
        return this.bGw.getViewHolder();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.j jVar, com.baidu.tbadk.core.view.viewpager.c cVar) {
        if (cVar == null || jVar == null || this.bGw == null) {
            return null;
        }
        a(cVar, jVar);
        d(cVar.ahf, view);
        return view;
    }

    private void d(int i, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bGw != null) {
            this.bGw.cK(skinType);
        }
        if (this.bFY != null && i != skinType) {
            this.bFY.getLayoutMode().ac(skinType == 1);
            this.bFY.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tbadk.core.view.viewpager.c cVar, com.baidu.tieba.hottopic.data.j jVar) {
        if (cVar != null && jVar != null) {
            cVar.ahk.setText(TbadkCoreApplication.m411getInst().getString(n.j.relate_forum_recommend));
            cVar.ahn.setVisibility(0);
            if (this.bGw != null) {
                if (jVar.bIb) {
                    this.bGw.setDatas(jVar.bIa);
                    jVar.bIb = false;
                }
                if (jVar.bIc) {
                    this.bGw.notifyDataSetChanged();
                    jVar.bIc = false;
                }
                this.bGw.getMoreView().setOnClickListener(new t(this, jVar));
            }
        }
    }
}
