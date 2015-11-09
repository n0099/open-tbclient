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
    private HotTopicActivity boH;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.boH = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.hottopic.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.d(LayoutInflater.from(this.boH.getPageContext().getPageActivity()).inflate(i.g.hot_topic_relate_forum_item, viewGroup, false), this.boH);
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
            an.i(dVar.bqt, i.e.list_item_selector);
            an.b(dVar.bqu, i.c.cp_cont_c, 1);
            an.j(dVar.bqw, i.c.cp_bg_line_b);
            an.b(dVar.bqv, i.c.cp_cont_d, 1);
        }
        if (view != null) {
            c(dVar.arf, view);
            if (dVar.bqy != null) {
                dVar.bqy.Rc();
            }
        }
    }

    private void c(int i, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.boH != null && i != skinType) {
            this.boH.getLayoutMode().ad(skinType == 1);
            this.boH.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (dVar != null && gVar != null) {
            dVar.bqu.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_recommend));
            dVar.bqw.setVisibility(0);
            boolean z = gVar.bpV || gVar.bpW;
            if (dVar.bqy != null && z) {
                dVar.bqy.a(gVar);
                gVar.bpV = false;
            }
            this.boH.a(dVar.bqy);
        }
    }
}
