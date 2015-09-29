package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.g, com.baidu.tieba.hottopic.b.d> {
    private HotTopicActivity bnS;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bnS = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.hottopic.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.d(LayoutInflater.from(this.bnS.getPageContext().getPageActivity()).inflate(i.g.hot_topic_relate_forum_item, viewGroup, false), this.bnS);
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
            am.j(dVar.getView(), i.c.cp_bg_line_d);
            am.i(dVar.bpE, i.e.list_item_selector);
            am.b(dVar.bpF, i.c.cp_cont_c, 1);
            am.j(dVar.bpH, i.c.cp_bg_line_b);
            am.b(dVar.bpG, i.c.cp_cont_d, 1);
        }
        if (view != null) {
            c(dVar.apR, view);
            if (dVar.bpJ != null) {
                dVar.bpJ.QK();
            }
        }
    }

    private void c(int i, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bnS != null && i != skinType) {
            this.bnS.getLayoutMode().ad(skinType == 1);
            this.bnS.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (dVar != null && gVar != null) {
            dVar.bpF.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_recommend));
            dVar.bpH.setVisibility(0);
            boolean z = gVar.bpg || gVar.bph;
            if (dVar.bpJ != null && z) {
                dVar.bpJ.a(gVar);
                gVar.bpg = false;
            }
            this.bnS.a(dVar.bpJ);
        }
    }
}
