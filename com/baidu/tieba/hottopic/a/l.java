package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.g, com.baidu.tieba.hottopic.b.d> {
    private HotTopicActivity bod;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bod = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.hottopic.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.d(LayoutInflater.from(this.bod.getPageContext().getPageActivity()).inflate(i.g.hot_topic_relate_forum_item, viewGroup, false), this.bod);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.g gVar, com.baidu.tieba.hottopic.b.d dVar) {
        if (dVar == null || gVar == null) {
            return null;
        }
        a(dVar, view);
        a(dVar, gVar);
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, View view) {
        if (dVar != null) {
            an.j(dVar.getView(), i.c.cp_bg_line_d);
            an.i(dVar.bpP, i.e.list_item_selector);
            an.b(dVar.bpQ, i.c.cp_cont_c, 1);
            an.j(dVar.bpS, i.c.cp_bg_line_b);
            an.b(dVar.bpR, i.c.cp_cont_d, 1);
        }
        if (view != null) {
            c(dVar.apS, view);
            if (dVar.bpU != null) {
                dVar.bpU.QG();
            }
        }
    }

    private void c(int i, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bod != null && i != skinType) {
            this.bod.getLayoutMode().ad(skinType == 1);
            this.bod.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (dVar != null && gVar != null) {
            dVar.bpQ.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_recommend));
            dVar.bpS.setVisibility(0);
            boolean z = gVar.bpr || gVar.bps;
            if (dVar.bpU != null && z) {
                dVar.bpU.a(gVar);
                gVar.bpr = false;
            }
            this.bod.a(dVar.bpU);
        }
    }
}
