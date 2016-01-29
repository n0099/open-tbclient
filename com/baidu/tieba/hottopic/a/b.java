package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.b, com.baidu.tieba.hottopic.b.a> {
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public com.baidu.tieba.hottopic.b.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.a(LayoutInflater.from(this.mContext).inflate(t.h.hot_topic_ranklist_head, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.b bVar, com.baidu.tieba.hottopic.b.a aVar) {
        if (bVar != null) {
            a(aVar);
            a(aVar, bVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.a aVar, com.baidu.tieba.hottopic.data.b bVar) {
        if (aVar != null && bVar != null) {
            String string = StringUtils.isNull(bVar.XK()) ? this.mContext.getResources().getString(t.j.hot_topic_hot_trend) : bVar.XK();
            aVar.bLJ.setText(bVar.XJ());
            aVar.bLH.setText(string);
            aVar.bLN.d(bVar.XI(), 10, false);
            if (StringUtils.isNull(bVar.getName())) {
                aVar.bLI.setVisibility(8);
                aVar.bLJ.setPadding(0, 0, 0, 0);
            } else {
                aVar.bLI.setVisibility(0);
                aVar.bLI.setText(bVar.getName());
            }
            aVar.bLO.setOnClickListener(new c(this, bVar));
        }
    }

    private void a(com.baidu.tieba.hottopic.b.a aVar) {
        if (aVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (aVar.ahU != this.mSkinType) {
                aVar.ahU = this.mSkinType;
                ar.l(aVar.getView(), t.d.cp_bg_line_d);
                ar.b(aVar.bLH, t.d.cp_cont_d, 1);
                ar.b(aVar.bLI, t.d.cp_cont_b, 1);
                ar.b(aVar.bLJ, t.d.cp_cont_c, 1);
                ar.l(aVar.bLL, t.d.cp_bg_line_c);
                ar.l(aVar.bLM, t.d.cp_bg_line_c);
                ar.k(aVar.bLO, t.f.hot_topic_ranklist_bg);
            }
        }
    }
}
